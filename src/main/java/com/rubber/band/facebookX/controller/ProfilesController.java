package com.rubber.band.facebookX.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubber.band.facebookX.model.ProfileDB;

@Controller
@RequestMapping("profiles")
public class ProfilesController {

	@RequestMapping("")
	public String getProfiles(Model model) {
		RestTemplate temp = new RestTemplate();
		String json = temp.getForObject("http://localhost:8080/FacebookX/getAllProfiles", String.class);
		System.out.println("Printing from Profiles Controller" + json);
		ObjectMapper map = new ObjectMapper();
		try {
			List<ProfileDB> list = map.readValue(json, new TypeReference<List<ProfileDB>>() {
			});
			System.out.println("Size of List Obtained : " + list.size());
			model.addAttribute("profileList", list);
		} catch (Exception e) {
			System.out.println("Exception in JSON Parser");
		}
		return "showprofiles";
	}

	@RequestMapping(value = "/{id}")
	public String checkProfile(@PathVariable("id") String id, Model model) {
		System.out.println("Profile ID To visit" + id);
		RestTemplate temp = new RestTemplate();
		String json = temp.getForObject("http://localhost:8080/FacebookX/getProfile/" + id, String.class);
		System.out.println("Length of json String : " + json.length());
		ObjectMapper map = new ObjectMapper();
		try {
			ProfileDB profile = map.readValue(json, ProfileDB.class);
			if (profile == null) {
				System.out.println("Profile is NULL");
			} else {
				System.out.println("Profile is Not NULL");
			}
			model.addAttribute("profile", profile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Check Profile");
		}
		return "profilepage";
	}
}
