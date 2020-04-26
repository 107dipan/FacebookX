package com.rubber.band.facebookX.mongoDb;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testCollection")
public class MongoDBTest {

	@Id
	private String id;
	String user;
	String role;
	List<MongoDBTest> listdb;

	public MongoDBTest() {
		// TODO Auto-generated constructor stub
	}

	public MongoDBTest(String id, String user, String role, List<MongoDBTest> list) {
		this.id = id;
		this.user = user;
		this.role = role;
		this.listdb = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<MongoDBTest> getListdb() {
		return listdb;
	}

	public void setListdb(List<MongoDBTest> listdb) {
		this.listdb = listdb;
	}

}
