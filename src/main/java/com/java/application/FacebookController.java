package com.java.application;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class FacebookController {

	private FacebookConnectionFactory factory = new FacebookConnectionFactory("1667244836743503", "c02825d9d76ae0b6b67fb8fe6687785e");
	
	@RequestMapping(value = "/root", method = RequestMethod.GET)
	public ModelAndView welcomeClientPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/useApplication", method = RequestMethod.GET)
	public ModelAndView authorizationCodeProducer() {

		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();

		params.setRedirectUri("http://localhost:8080/forwardLogin");
		params.setScope("email,public_profile");

		String url = operations.buildAuthenticateUrl(params);
		return new ModelAndView("redirect:" + url);
	}
	
	@RequestMapping(value = "/forwardLogin", method = RequestMethod.GET, produces = "application/xml")
	public ModelAndView accessFacebookUserDetailsAPIUsingToken(@RequestParam("code") String authorizationCode) {
		
		OAuth2Operations operations = factory.getOAuthOperations();
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8080/forwardLogin",
				null);

		Connection<Facebook> connection = factory.createConnection(accessToken);
		Facebook facebook = connection.getApi();
		String[] fields = { "id", "email", "first_name", "last_name" };
		User userProfile = facebook.fetchObject("me", User.class, fields);
		ModelAndView model = new ModelAndView("details");
		model.addObject("user", userProfile);
		return model;
	}
	
}
