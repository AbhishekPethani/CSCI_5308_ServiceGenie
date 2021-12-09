package com.servicegenie.controllers;

import com.servicegenie.constants.CustomerUtil;
import com.servicegenie.models.Offer;
import com.servicegenie.models.Order;
import com.servicegenie.models.ServiceForCustomers;
import com.servicegenie.services.BuyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
public class BuyServiceController {

    @Autowired
    private BuyServiceService buyServiceService;

    @GetMapping("/buy-service")
    public String getServices(Model model) throws SQLException {
        List<ServiceForCustomers> serviceForCustomersList = buyServiceService.getAllServices();
        model.addAttribute("serviceList", serviceForCustomersList);
        return "BuyNewService";
    }

    @PostMapping("/pay-service/{serviceID}")
    public String payForService(@PathVariable String serviceID, Model model) {
        ServiceForCustomers theServiceForCustomers = buyServiceService.getServiceByID(serviceID);
        Double finalAmountAfterTax = theServiceForCustomers.getServicePrice() * 1.15;
        model.addAttribute("service", theServiceForCustomers);
        finalAmountAfterTax = Math.round(finalAmountAfterTax * 100.0) / 100.0;
        model.addAttribute("finalAmount", finalAmountAfterTax);
        return "PaymentPage";
    }

    @PostMapping("/applyCoupon/{serviceID}")
    public String applyCodeForService(@PathVariable String serviceID, Model model, HttpServletRequest request) {

        String couponCode = request.getParameter("code");
        ServiceForCustomers theServiceForCustomers = this.buyServiceService.getServiceByID(serviceID);
        Offer offer = theServiceForCustomers.getOffer();
        model.addAttribute("service", theServiceForCustomers);
        Double finalAmountAfterTax = theServiceForCustomers.getServicePrice() * 1.15;
        if (offer.getOfferCode().equalsIgnoreCase(couponCode)) {
            Double discountedAmount = (finalAmountAfterTax * offer.getDiscountPercentage()) / 100;
            if (discountedAmount > offer.getMinimumAmount()) {
                discountedAmount = offer.getMinimumAmount();
            }
            theServiceForCustomers.setServicePrice(theServiceForCustomers.getServicePrice()-discountedAmount);
            finalAmountAfterTax = theServiceForCustomers.getServicePrice() * 1.15;
            finalAmountAfterTax = Math.round(finalAmountAfterTax * 100.0) / 100.0;
            model.addAttribute("finalAmount", finalAmountAfterTax);
            model.addAttribute("msg", CustomerUtil.COUPON_SUCCESS.toString());
        } else {
            finalAmountAfterTax = Math.round(finalAmountAfterTax * 100.0) / 100.0;
            model.addAttribute("finalAmount", finalAmountAfterTax);
            model.addAttribute("msg", CustomerUtil.COUPON_FAILURE.toString());
        }
        model.addAttribute("service", theServiceForCustomers);
        return "PaymentPage";
    }

    @PostMapping("/buyService/{serviceID}")
    public String buyService(@PathVariable String serviceID, Model model, HttpServletRequest request) throws SQLException {

        String couponCode = request.getParameter("code");
        ServiceForCustomers theServiceForCustomers = this.buyServiceService.getServiceByID(serviceID);
        String finalAmount = request.getParameter("final_amount");
        Double finalAmountAfterTax = Double.parseDouble(finalAmount);
        Order order = new Order();
        order.setService(theServiceForCustomers);
        order.setOrderAmount(finalAmountAfterTax);
        order.setCustomerID(CustomerUtil.CUSTOMER_ID.toString());
        order.setOrderDate(new Date());
        boolean isOrderPlaced = this.buyServiceService.placeOrder(order);
        if (isOrderPlaced) {
            model.addAttribute("msg", CustomerUtil.ORDER_SUCCESS.toString());
            return "UserHomePage";
        } else {
            model.addAttribute("msg", CustomerUtil.ORDER_FAILURE.toString());
            model.addAttribute("service", theServiceForCustomers);
            finalAmountAfterTax = Math.round(finalAmountAfterTax * 100.0) / 100.0;
            model.addAttribute("finalAmount", theServiceForCustomers.getServicePrice()*1.15);
            return "PaymentPage";
        }

    }

}
