package no.solhaug.booking.controllers;

import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Customer;
import no.solhaug.booking.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping ("/registercustomer")
    public String registerCustomer(@RequestParam(name="firstname") String firstname,
                                   @RequestParam(name="lastname") String lastname,
                                   @RequestParam(name="email") String email,
                                   @RequestParam(name="phonenumber") String phonenumber,
                                   RedirectAttributes redirectAttributes){
    Customer customer = new Customer();

    customer.setFirstName(firstname);
    customer.setLastName(lastname);
    customer.setEmail(email);
    customer.setPhone(phonenumber);

    customerService.saveCustomer(customer);
    redirectAttributes.addFlashAttribute("customer",customer);

        return "redirect:/customerconfirmation";
    }


    @GetMapping("/customerconfirmation")
    public String customerconfirmation (){
        return "customerconfirmation";
    }



    @GetMapping("/customer")
    public String showAccountPage(){
        return "customerForm";
    }
}
