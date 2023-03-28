package com.example.Drone_Booking_application.Contoller;

import com.example.Drone_Booking_application.Entity.User;
import com.example.Drone_Booking_application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/Users")
    public String getHello(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping("/users/new")
    public String addUser(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "add_user";

    }
    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/Users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUsers(@PathVariable Long id,
                                @ModelAttribute("user") User user,
                                Model model) {

        // get student from database by id
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());

        // save updated student object
        userService.updateUser(existingUser);
        return "redirect:/Users";
    }
    @GetMapping("/users/book/{id}")
    public String bookUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "booking_details";
    }

    // handler method to handle delete student request

    @GetMapping("/users/{id}")
    public String deleteStudent(@PathVariable Long id) {
        userService.deleteUsertById(id);
        return "redirect:/Users";
    }

}

