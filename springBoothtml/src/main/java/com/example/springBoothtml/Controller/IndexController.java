package com.example.springBoothtml.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springBoothtml.Model.Register;
import com.example.springBoothtml.Model.User;
import com.example.springBoothtml.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";

	}

	@PostMapping("/login")
	public String userRegistration(@ModelAttribute User user, Model model) {
		boolean isUser = false;
		System.out.println(user.toString());
		if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
			isUser = userService.getUserDetails(user.getUsername());
		}
		if (isUser) {
			model.addAttribute("username", user.getUsername());
			return "welcome";
		} else {
			return "index";
		}
	}

	@PostMapping("/home")
	public String userSignUp(@ModelAttribute Register reg, Model model) {
		System.out.println(reg.toString());
		System.out.println(reg.getStatus());
		model.addAttribute("status", reg.getStatus());
		if (model.getAttribute("status").equals("login")) {
			return "login";
		} else {
			return "signUp";
		}
	}

	@PostMapping("/signUp")
	public String signUp(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		model.addAttribute("username", user.getUsername());
		if (!model.getAttribute("username").toString().isEmpty() || model.getAttribute("username") != null
				|| !model.getAttribute("username").equals(null)) {
			model.addAttribute("username", user.getUsername());
			model.addAttribute("password", user.getPassword());
			userService.save(user);
			return "login";
		} else {
			return "index";
		}
	}

}
