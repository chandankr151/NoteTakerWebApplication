package com.springmvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(path = "/home", method=RequestMethod.GET)
	public String homePage() {

		return "home";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

//	@RequestMapping(path = "/addNotes")
//	public String addNotes() {
//
//		return "add_notes";
//	}
//
//	@RequestMapping(path = "/viewNotes")
//	public String viewNotes() {
//		return "view_notes";
//	}
//
//	@RequestMapping(path = "/editNotes")
//	public String editNotes() {
//		return "edit_notes";
//	}

	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, HttpSession session) {

		userDao.saveUser(user);
		session.setAttribute("msg", "Registered Successfully.");
		return "redirect:/register";
	}

	@RequestMapping(path = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String pass,
			HttpSession session) {

		User user = userDao.login(email, pass);
		if (user != null) {
			session.setAttribute("userObj", user);
			return "redirect:/home";
		} else {
			session.setAttribute("msg", "Invalid Email or Password.");
			return "redirect:/login";
		}
	}
}
