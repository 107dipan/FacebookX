package com.rubber.band.facebookX.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;
import com.rubber.band.facebookX.model.WrapperClass;
import com.rubber.band.facebookX.mongoDb.MongoMain;
import com.rubber.band.facebookX.service.DBResponse;
import com.rubber.band.facebookX.service.ProfileService;

@Controller
public class EntryController {
	ProfileService profService;
	MongoMain mongoMain;

	@Autowired
	public void setService(ProfileService service) {
		System.out.println("Controller set service");
		this.profService = service;
	}

	@Autowired
	public void setMongoMain(MongoMain mongoMain) {
		System.out.println("Controller set mongo");
		this.mongoMain = mongoMain;
	}

	@RequestMapping(value = "")
	public String firstEnty(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("userId") == null) {
			return "index";
		} else {
			String userId = (String) session.getAttribute("userId");
			ProfileDB profile = profService.getProfile(userId);
			if(profile == null) {
				System.out.println("No Profile Found");
				return "index";
			} else {
				model.addAttribute("profile", profile);
				return "profilepage";
			}
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		ProfileDB profile = profService.login(email, password);
		if (profile == null) {
			System.out.println("Login Not Successful");
			return "";
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("userId", profile.getUserId());
			model.addAttribute("profile", profile);
			return "profilepage";
		}
	}

	@RequestMapping(value = "signup")
	public String signUp(Model model) {
		/*
		 * mongoMain.createCollections(); mongoMain.retrieveDocuments();
		 * mongoMain.saveData(); mongoMain.retrieveDocuments();
		 */
		/*
		 * RestTemplate temp = new RestTemplate(); String json =
		 * temp.getForObject("http://localhost:8080/FacebookX/restTest", String.class);
		 * mongoMain.saveData(json);
		 */

		model.addAttribute("wrap", new WrapperClass());
		return "signupform";
	}

	@RequestMapping(value = "signupsubmit", method = RequestMethod.POST)
	public String signUpForm(@ModelAttribute("wrap") WrapperClass wrap, Model model) {
		System.out.println("SignUpForm Controller");
		AuthenticationDB auth = wrap.getAuth();
		ProfileDB profile = wrap.getProf();
		System.out.println(auth.getEmailId() + " " + auth.getPassword());
		String resp = profService.addProfile(auth, profile);
		if (resp.equals(DBResponse.ProfileCreated.toString())) {
			model.addAttribute("profile", profile);
			return "profilepage";
		} else {
			System.out.println("Profile Not Created");
			return "signupform";
		}
	}
}
