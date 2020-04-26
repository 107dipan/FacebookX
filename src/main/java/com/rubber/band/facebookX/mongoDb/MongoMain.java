package com.rubber.band.facebookX.mongoDb;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class MongoMain {
	MongoTemplate mongoTemplate;

	@Autowired
	public MongoMain(MongoTemplate mongoTemplate) {
		System.out.println("MongoDb Parameterized Constructor");
		this.mongoTemplate = mongoTemplate;
	}

	public void createCollections() {
		try {
			MongoDatabase database = mongoTemplate.getDb();
			if (database == null) {
				System.out.println("Database was not found");
			} else {
				System.out.println("Database was found");
			}
			database.createCollection("testCollection");
		} catch (Exception e) {
			System.out.println("Exception in Create collection");
		}
	}

	public void retrieveDocuments() {
		try {
			MongoDatabase database = mongoTemplate.getDb();
			if (database == null) {
				System.out.println("Database was not found, Retrieve Documents");
			}
			MongoCollection<Document> collection = database.getCollection("testCollection");
			if (collection == null) {
				System.out.println("Collection is NULL in retrieve documents");
			} else {
				System.out.println("Collection is Not NUll, Size : ");
				Iterator itr = collection.find().iterator();
				while (itr.hasNext()) {
					Object obj = itr.next();
					System.out.println("Object Type : " + obj.getClass().toString());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in retrieve documents");
		}
	}

	public void saveData() {
		// MongoDBTest db1 = new MongoDBTest("x", "dipan", "eng");
		// MongoDBTest db2 = new MongoDBTest("y", "bruce", "ceo");
		MongoDatabase database = mongoTemplate.getDb();
		if (database == null) {
			System.out.println("Database was not found, Retrieve Documents");
		}
		MongoCollection<Document> collection = database.getCollection("testCollection");
		Document d1 = new Document("name", "dipan").append("title", "ceo");
		Document d2 = new Document("name", "bruce").append("title", "batman");
		collection.insertOne(d1);
		collection.insertOne(d2);
	}
	
	public void saveData(String json) {
		MongoDatabase database = mongoTemplate.getDb();
		if (database == null) {
			System.out.println("Database was not found, Retrieve Documents");
		} else {
			System.out.println("Database Found");
		}
		MongoCollection<Document> collection = database.getCollection("testCollection");
		Document d = Document.parse(json);
		collection.insertOne(d);
	}
}
