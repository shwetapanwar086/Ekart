package com.MobiShop.MobiShopBackend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MobiShop.MobiShopBackend.dao.UsersDetailDao;
import com.MobiShop.MobiShopBackend.model.UsersDetail;

import java.util.List;

import javax.validation.Valid;

/*
 * This Controller is used to register user into the system
 */
@Controller
public class UserRegistrationController {

	@Autowired
	private UsersDetailDao usersDetailDAO;

	/*
	 * registerUserPost method is used to register user into the system and to
	 * show registration related errors
	 */

	
	@RequestMapping("/register")
	public String registerUser(Model model) {

		UsersDetail usersDetail = new UsersDetail();
		model.addAttribute("usersDetail", usersDetail);
		return "register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPost(@Valid @ModelAttribute("usersDetail") UsersDetail usersDetail,
			BindingResult result) {
		
		if (result.hasErrors()) {					
			ModelAndView model=new ModelAndView("register");
			model.addObject("message", "You have entered invalid details");
			
			System.out.println("Page has errors");
			return model;
		}
		
		List<UsersDetail> usersDetailList = usersDetailDAO.getAllUsers();

        for (int i=0; i< usersDetailList.size(); i++) {
        	ModelAndView model=new ModelAndView("customerRegister");
        	if(usersDetail.getUserEmail().equals(usersDetailList.get(i).getUserEmail())) {
                model.addObject("emailError", "Email already exists");

                return model;
            }

            if(usersDetail.getUsername().equals(usersDetailList.get(i).getUsername())) {
                model.addObject("usernameError", "Username already exists");
                return model;
            }
            if(usersDetail.getUserPhone().equals(usersDetailList.get(i).getUserPhone())) {
                model.addObject("userPhoneError", "User phone already exists");
                return model;
            }
        }
		/*if(usersDetailDAO.isValidUser(usersDetail.getUsername())==false){
			ModelAndView model=new ModelAndView("customerRegister");
			model.addObject("usernameError", "User name already exists");
			return model;
		}*/
		usersDetail.setEnabled(true);
		usersDetailDAO.addUser(usersDetail);
		ModelAndView model=new ModelAndView("registrationSuccess");
		return model;
	}
}