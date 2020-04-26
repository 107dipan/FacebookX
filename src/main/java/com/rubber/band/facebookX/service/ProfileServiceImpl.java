package com.rubber.band.facebookX.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rubber.band.facebookX.dao.ProfileDAO;
import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;

public class ProfileServiceImpl implements ProfileService {
	ProfileDAO profDao;

	@Autowired
	public void setProfile(ProfileDAO profile) {
		System.out.println("Setting profile in ProfileServiceImpl");
		this.profDao = profile;
	}

	@Override
	public String addProfile(AuthenticationDB auth, ProfileDB profile) {
		if (profDao.isEmailExits(auth.getEmailId())) {
			return DBResponse.EmailAlreadyExists.toString();
		} else {
			if (profDao.addProfile(auth, profile)) {
				return DBResponse.ProfileCreated.toString();
			} else {
				return DBResponse.ProfileCreationFailed.toString();
			}
		}
	}

	@Override
	public ProfileDB login(String email, String password) {
		ProfileDB profile = null;
		String resp = profDao.authenticate(email, password);
		if (resp.equals(DBResponse.IncorrectPassword.toString())
				|| resp.equals(DBResponse.EmailDoesNotExist.toString())) {
			System.out.println(resp);
		} else {
			profile = profDao.getProfile(resp);
		}
		return profile;
	}

	@Override
	public List<ProfileDB> getProfiles() {
		return profDao.getAllProfiles();
	}

	@Override
	public ProfileDB getProfile(String id) {
		ProfileDB profile = profDao.getProfile(id);
		return profile;
	}

}
