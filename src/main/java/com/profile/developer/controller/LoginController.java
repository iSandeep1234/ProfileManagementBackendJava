package com.profile.developer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.profile.developer.bean.User;
import com.profile.developer.service.LoginService;





@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
    	model.addAttribute("command", new User());
        return "index";
    }
    

    @RequestMapping(value="/save", method = RequestMethod.GET)
    public String showCarrierObjective(Model model){
    	model.addAttribute("command", new User());
        return "carrierObjective";
    }
	/*
	 * @RequestMapping("/contact") public String showContacts(Model m) {
	 * m.addAttribute("command", new Contact()); return "contact"; }
	 */

	/*
	 * @RequestMapping(value="/login", method = RequestMethod.POST) public String
	 * showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam
	 * String password){
	 * 
	 * boolean isValidUser = service.validateUser(name, password);
	 * 
	 * if (!isValidUser) { model.put("errorMessage", "Invalid Credentials"); return
	 * "login"; }
	 * 
	 * model.put("name", name); model.put("password", password);
	 * 
	 * return "welcome"; }
	 */

}
