package com.rubber.band.facebookX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubber.band.facebookX.mongoDb.MongoDBTest;

@RestController
public class TestRESTController {
	@GetMapping("/restTest")
	public MongoDBTest getTestREST() {
		System.out.println("Inside REST Controller");
		MongoDBTest ob1 = new MongoDBTest("dipan", "roy", "eng", null);
		MongoDBTest ob2 = new MongoDBTest("aniket", "sinha", "eng", null);
		List<MongoDBTest> list = new ArrayList<MongoDBTest>();
		list.add(ob1);
		list.add(ob2);
		MongoDBTest obj = new MongoDBTest("bruce", "wayne", "batman", list);
		return obj;
	}
}
