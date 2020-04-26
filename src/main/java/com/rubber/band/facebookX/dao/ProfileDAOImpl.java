package com.rubber.band.facebookX.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;
import com.rubber.band.facebookX.service.DBResponse;

public class ProfileDAOImpl implements ProfileDAO {
	HibernateTemplate template;

	@Autowired(required = false)
	public void setTemplate(HibernateTemplate template) {
		System.out.println("Hibernate template  is set in ProfileDAO");
		this.template = template;
	}

	private static String generateId(AuthenticationDB auth) {
		String str = auth.getEmailId();
		String id = str.substring(0, str.length() - 3);
		System.out.println("Generating ID : " + id);
		return id;
	}

	@Override
	public boolean isEmailExits(String emailId) {
		// TODO Auto-generated method stub
		AuthenticationDB obj = (AuthenticationDB) template.get(AuthenticationDB.class, emailId);
		if (obj != null)
			return true;
		else
			return false;
	}

	@Override
	public String authenticate(String email, String password) {
		AuthenticationDB obj = (AuthenticationDB) template.get(AuthenticationDB.class, email);
		if (obj == null) {
			return DBResponse.EmailDoesNotExist.toString();
		}
		if (!password.equals(obj.getPassword())) {
			return DBResponse.IncorrectPassword.toString();
		}

		return obj.getId();
	}

	@Override
	public boolean addProfile(AuthenticationDB auth, ProfileDB prof) {
		try {
			String id = generateId(auth);
			auth.setId(id);
			prof.setUserId(id);
			System.out.println("Get Date for Profile : " + prof.getDateOfBirth());
			System.out.println(auth.toString());
			System.out.println(prof.toString());
			template.save(auth);
			template.save(prof);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public void deleteProfile(AuthenticationDB auth, ProfileDB prof) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProfileDB getProfile(String id) {
		System.out.println("ProfileDAO : " + id + " size : " + id.length());
		return (ProfileDB) template.get(ProfileDB.class, id);
	}

	@Override
	public List<ProfileDB> getAllProfiles() {
		List<ProfileDB> list = new ArrayList<ProfileDB>();
		list = template.loadAll(ProfileDB.class);
		return list;
	}

}
