package com.carrenting.spring.controller;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import com.carrenting.spring.validation.ValidPassword;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.security.Principal;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ProfileController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public String getProfile(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userLogged");
        model.addAttribute("userProfile", user);
        return "profile";
    }

    @GetMapping("/password")
    public String getChangePassword(Model model) {
        return "changePassword";
    }

    @PostMapping("/password")
    public String changePassword(@RequestParam("oldPassword") String oldPasswordPage,
                                 @RequestParam("newPassword") @Min(value = 8, message = "{ValidPassword.User.password.validation}") String newPasswordPage,
                                 Model model, HttpSession httpSession, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "changePassword";
        } else {
            User user = (User) httpSession.getAttribute("userLogged");
            if (bCryptPasswordEncoder.matches(oldPasswordPage, user.getPassword())) {
                String newPasswordCripted = bCryptPasswordEncoder.encode(newPasswordPage);
                user.setPassword(newPasswordCripted);
                userService.addUser(user);
                httpSession.setAttribute("userLogged", user);
                return "redirect:/profile?succPass";
            } else {
                return "redirect:/profile/password?error";
            }
        }

    }

    @PostMapping
    private String updateProfile(Model model, @Valid @ModelAttribute("userProfile") User newUserProfile, HttpSession httpSession, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            User user = (User) httpSession.getAttribute("userLogged");
            model.addAttribute("userProfile", user);
            return "profile";
        }
        User oldUserProfile = (User) httpSession.getAttribute("userLogged");
        oldUserProfile.setFirstname(newUserProfile.getFirstname());
        oldUserProfile.setLastname(newUserProfile.getLastname());
        oldUserProfile.setBirthDate(newUserProfile.getBirthDate());
        oldUserProfile.setUsername(newUserProfile.getUsername());
        userService.addUser(oldUserProfile);
        httpSession.setAttribute("userLogged", oldUserProfile);
        return "redirect:/profile?success";

    }
}
