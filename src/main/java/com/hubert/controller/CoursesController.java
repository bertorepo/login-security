package com.hubert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController {

	@GetMapping("/courses")
	public String displayCoursesPage() {
		return "This is the Courses Page";
	}
}
