package com.homeassist.assistdemo.controller;

import com.homeassist.assistdemo.dao.BookingRepository;
import com.homeassist.assistdemo.dao.CustomerRepository;
import com.homeassist.assistdemo.entity.Booking;
import com.homeassist.assistdemo.entity.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DemoController {

    //creating mapping for home page

    @GetMapping("/home")
    public String home_page()
    {
        return "homepage";
    }
    @GetMapping("/login")
    public String login(){
        return "login1";
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register1";
    }

    @GetMapping("/services")
    public String services(){
        return "Services";
    }

    @GetMapping("/homeTab")
    public String home(){
        return "Home";
    }

    @GetMapping("/about")
    public String About(){
        return "AboutUs";
    }

    @GetMapping("/homeIn")
    public String homeIn(){
        return "home_in";
    }

    @GetMapping("/userform")
    public String booking(){
        return "userform";
    }

    @GetMapping("/submit")
    public String submit(){
        return "submit";
    }

    @Autowired
    private CustomerRepository customerRepository;

    /*@PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if (customer.isPresent() && customer.get().getPassword().equals(password)) {
            return "home_in";
        } else {
            return "Invalid username or password.";
        }
    }*/



    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/userform")
    public String handleFormSubmission(@ModelAttribute Booking booking) {

        // Save booking to database
        bookingRepository.save(booking);

        // Redirect to a success page (or any other page)
        return "submit";
    }

    @GetMapping("/myServices")
    public String viewMyServices(HttpSession session, Model model) {
        // Get the email of the logged-in user from the session
        String email = (String) session.getAttribute("userEmail");


        // Fetch services from the booking table by email
        List<Booking> booking = bookingRepository.findByEmail(email);

        if (booking.isEmpty()) {
            model.addAttribute("error", "No bookings found for your account.");
        } else {
            model.addAttribute("booking", booking);
        }

        return "myservices"; // Return the My Services page
    }

}
