package com.containersol.mini;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoint {

	@RequestMapping("hello")
	public HelloData helloWorld() {
		return new HelloData("p1", "p2");
	}
}
