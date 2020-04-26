package com.rubber.band.facebookX.service;

import java.sql.Date;
import java.util.List;

import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;

public interface ProfileService {
	public String addProfile(AuthenticationDB auth, ProfileDB profile);

	public ProfileDB login(String email, String password);
	
	public List<ProfileDB> getProfiles();
	
	public ProfileDB getProfile(String id);
}
