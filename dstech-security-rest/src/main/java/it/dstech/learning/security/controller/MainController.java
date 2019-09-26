package it.dstech.learning.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class MainController {

		@GetMapping
		public String getResources(){
			return "hello";
		}
		
		@PreAuthorize("hasAnyRole('ADMIN')")
		@GetMapping("/secured")
		public String getSecuredResources(){
			return "secured data";
		}
		
}
