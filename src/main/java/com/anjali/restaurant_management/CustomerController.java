package com.anjali.restaurant_management;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/submitCustomer")
    public String submitCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "index";
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerList";
    }
}
