package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import com.udemy.util.ViewConstant;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);

	private static int count = 0;

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public ModelAndView showContacts() {
		this.add();
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("contacts", contactService.listContacts());
		return mav;
	}

	@GetMapping("/cancel")
	public String cancel(Model model) {
		LOG.info("METHOD: cancel()");
		return "redirect:/" + ViewConstant.CONTACTS + "/";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	public String redirectContactForm(Model model){
		LOG.info("METHOD: redirectContactForm()");
		model.addAttribute("contactModel", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}

	@GetMapping("/editcontact")
	public String editContact(Model model, @RequestParam(name = "id", required = false) int id) {
		ContactModel contactModel = new ContactModel();
		contactModel = contactService.findContactModelById(id);
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addcontact")
	public String addContact(Model model, @ModelAttribute(name = "contactModel") ContactModel contactModel) {
		LOG.info("METHOD: addContact() ---PARAMS: " + contactModel);
		if (contactService.addContact(contactModel) != null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/" + ViewConstant.CONTACTS + "/";
	}

	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}

	private void add() {
		if (count == 0) {
			ContactModel m1 = new ContactModel("Joao", "Silva", "Salvador", "(55)555555555");
			ContactModel m2 = new ContactModel("Maria", "Silva", "Salvador", "(55)555555555");

			contactService.addContact(m1);
			contactService.addContact(m2);
		}
		count++;
	}
}
