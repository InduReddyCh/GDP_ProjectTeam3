package com.spring.GDProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

	

		@RequestMapping("login")
		public String login()
		{
			return "login.html";
		}
		
		@RequestMapping("registration")
		public String registration()
		{
			return "registration.html";
		}

		@RequestMapping("home")
		public String home()
		{
			return "home.html";
		}
}


