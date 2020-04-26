package com.rubber.band.facebookX.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/posts")
public class PostController {
	
	@RequestMapping("")
	public String myPosts(HttpServletRequest req) {
		System.out.println("userId : " + req.getParameter("userId"));
		return "postPage";
	}
}
