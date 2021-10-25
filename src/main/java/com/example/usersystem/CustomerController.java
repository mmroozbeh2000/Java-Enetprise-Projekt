package com.example.usersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping( method = RequestMethod.GET)
    private String getAllCustomers(Model model) {
        List<Customer> list = customerService.loadAllCustomers();
        model.addAttribute("allCustomers", list);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewCustomerPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveNewCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    private String editCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.loadCustomerById(id);
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateCustomer(@PathVariable("id") int id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    private String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }




}