package com.rubber.band.facebookX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rubber.band.facebookX.model.ProfileDB;
import com.rubber.band.facebookX.service.ProfileService;

@RestController
public class ProfileRESTController {
	ProfileService profService;

	@Autowired
	public void setProfService(ProfileService profService) {
		System.out.println("Setting Profile Service In Profile REST Controller");
		this.profService = profService;
	}

	@GetMapping("getAllProfiles")
	public List<ProfileDB> getProfiles() {
		List<ProfileDB> list = profService.getProfiles();
		return list;
	}

	@GetMapping("getProfile/{id}")
	public ProfileDB getProfile(@PathVariable("id") String id) {
		System.out.println("Getting Profile : " + id);
		ProfileDB profileDB = profService.getProfile(id);
		if(profileDB == null) {
			System.out.println("No Profile Retrieved");
		} else {
			System.out.println("Profile Retrieved " + profileDB.getName() + " " + profileDB.getUniversity());
		}
		return profileDB;
	}

}
