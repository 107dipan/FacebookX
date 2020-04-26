package com.rubber.band.facebookX.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rubber.band.facebookX.model.AuthenticationDB;
import com.rubber.band.facebookX.model.ProfileDB;

public class Main {
	public static void main(String args[]) {
		/*try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			//AuthenticationDBController auth = (AuthenticationDBController) context.getBean("authdbBean");
			DBController prof = (DBController) context.getBean("profdbBean");
			
			AuthenticationDB ob1 = new AuthenticationDB();
			ob1.setEmailId("107dipan@gmail.com");
			ob1.setPassword("Root@1234");
			ob1.setId("dipan");
			
			prof.saveEntity(ob1);
			
			ProfileDB ob = new ProfileDB();
			ob.setUserId("dipan");
			ob.setName("Dipan Roy");
			ob.setPlaceOfBirth("Kolkata");
			ob.setWork("Oracle");
			ob.setGender("Male");
			
			
			prof.saveEntity(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
