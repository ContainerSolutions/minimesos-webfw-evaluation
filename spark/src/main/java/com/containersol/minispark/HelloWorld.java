package com.containersol.minispark;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		port(8080);
		get("/hello", (request, response) -> {
			response.header("Content-Type", "application/json");
			return new HelloData("param1", "param2", usedMemory());
		}, JsonUtil.json());
	}

	private static long usedMemory() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		return runtime.totalMemory() - runtime.freeMemory();
	}
}