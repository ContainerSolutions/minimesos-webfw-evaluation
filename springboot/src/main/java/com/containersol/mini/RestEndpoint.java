package com.containersol.mini;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoint {

	@RequestMapping("hello")
	public HelloData helloWorld() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();

		return new HelloData("p1", "p2", usedMemory);
	}
}
