package com.rubber.band.facebookX.dao;

import java.util.List;

import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;

public interface ProfileDAO {

	public boolean isEmailExits(String emailId);

	public boolean addProfile(AuthenticationDB auth, ProfileDB prof);

	public void deleteProfile(AuthenticationDB auth, ProfileDB prof);

	public String authenticate(String email, String password);

	public ProfileDB getProfile(String id);
	
	public List<ProfileDB> getAllProfiles();
}
