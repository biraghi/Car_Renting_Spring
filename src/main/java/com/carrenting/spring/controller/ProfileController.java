package com.carrenting.spring.controller;

import com.carrenting.spring.entity.PasswordChange;
import com.carrenting.spring.entity.User;
import com.carrenting.spring.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String USER_LOGGED = "userLogged";

    public ProfileController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public String getProfile(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(USER_LOGGED);
        model.addAttribute("userProfile", user);
        return "profile";
    }

    @GetMapping("/password")
    public String getChangePassword(Model model) {
        PasswordChange passwordChange = new PasswordChange();
        model.addAttribute("passwordChange", passwordChange);
        return "changePassword";
    }

    @PostMapping("/password")
    public String changePassword(@Valid @ModelAttribute("passwordChange")PasswordChange passwordChange, BindingResult bindingResult,
                                 HttpSession httpSession) {
        if (bindingResult.hasErrors()){
            return "changePassword";
        }

        User user = (User) httpSession.getAttribute(USER_LOGGED);

        if (bCryptPasswordEncoder.matches(passwordChange.getOldPassword(), user.getPassword())) {
            String newPasswordCripted = bCryptPasswordEncoder.encode(passwordChange.getNewPassword());
            user.setPassword(newPasswordCripted);
            userService.addUser(user);
            httpSession.setAttribute(USER_LOGGED, user);
            return "redirect:/profile?succPass";
        } else {
            return "redirect:/profile/password?error";
        }


    }

    @PostMapping
    public String updateProfile(@Valid @ModelAttribute("userProfile") User newUserProfile, HttpSession httpSession, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            User user = (User) httpSession.getAttribute(USER_LOGGED);
            model.addAttribute("userProfile", user);
            return "profile";
        }
        User oldUserProfile = (User) httpSession.getAttribute(USER_LOGGED);

        if (userService.getUserFromUsername(newUserProfile.getUsername()) != null && newUserProfile.getUsername().equals(oldUserProfile.getUsername())) {
            model.addAttribute("error", "Username già presente");
            return "profile";
        }
        userService.addUser(userService.setParamForUpdate(oldUserProfile, newUserProfile));
        httpSession.setAttribute(USER_LOGGED, oldUserProfile);
        return "redirect:/profile?success";

    }
}
