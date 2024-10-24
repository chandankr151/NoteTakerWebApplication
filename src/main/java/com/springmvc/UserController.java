package com.springmvc;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.Notes;
import com.springmvc.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(path = "/addNotes")
	public String addNotes() {

		return "add_notes";
	}

	@RequestMapping(path = "/viewNotes")
	public String viewNotes(Model m, HttpSession session) {
		User us = (User) session.getAttribute("userObj");

		List<Notes> notes = userDao.getNotesByUser(us);
		m.addAttribute("list", notes);

		return "view_notes";
	}

	@RequestMapping(path = "/editNotes")
	public String editNotes() {
		return "edit_notes";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userObj");
		session.setAttribute("msg", "logout Successfully.");
		return "login";
	}

	@RequestMapping(path = "/saveNotes", method = RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes notes, HttpSession session) {
		User us = (User) session.getAttribute("userObj");
		notes.setDate(LocalDateTime.now().toString());

		notes.setUser(us);
		int saveNotes = userDao.saveNotes(notes);
		session.setAttribute("msg", "Notes Added Successfully");

		System.out.println(saveNotes + " Notes Added Successfully.");
		return "redirect:/user/addNotes";
	}

	@RequestMapping(path = "/deleteNotes", method = RequestMethod.GET)
	public String deleteNotes(@RequestParam("id") int id, HttpSession session) {

		userDao.deleteNotes(id);
		session.setAttribute("msg", "Notes deleted Successfully.");

		return "redirect:/user/viewNotes";
	}

	@RequestMapping(path = "/editNotes", method = RequestMethod.GET)
	public String editNoted(@RequestParam("id") int id, Model m) {
		Notes notes = userDao.getNotesById(id);
		m.addAttribute("notes", notes);

		return "edit_notes";
	}

	@RequestMapping(path = "/updateNotes", method = RequestMethod.POST)
	public String updateNotes(@ModelAttribute Notes notes, HttpSession session) {

		User us = (User) session.getAttribute("userObj");

		notes.setUser(us);
		notes.setDate(LocalDateTime.now().toString());
				
		userDao.updateNotes(notes);
		session.setAttribute("msg", "Notes Updated Successfully");
		
		return "redirect:/user/viewNotes";
	}
}
