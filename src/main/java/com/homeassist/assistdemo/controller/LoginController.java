package com.homeassist.assistdemo.controller;

import com.homeassist.assistdemo.dao.CustomerRepository;
import com.homeassist.assistdemo.entity.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);

        if (customer != null) {
            // Store the user's email in the session
            session.setAttribute("userEmail", email);
            return "home_in"; // Redirect to My Services page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login1"; // Return to the login page with an error
        }
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email, Model model, HttpSession session) {

        // Check if the user already exists
        if (customerRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Provided Email already exists. Please Log In.");
            return "register1";
        }

        // Save the new user to the database
        Customer newCustomer = new Customer();
        newCustomer.setUsername(username);
        newCustomer.setPassword(password); // Encrypt this in production
        newCustomer.setEmail(email);

        customerRepository.save(newCustomer);
        session.setAttribute("userEmail", email);
        return "home_in";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        return "homepage"; // Redirect to login page
    }


}
