package com.containersol.minivertx;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		port(8080);
		get("/hello", (request, response) -> {
			response.header("Content-Type", "application/json");
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
			long usedMemory = runtime.totalMemory() - runtime.freeMemory();
			return new HelloData("param1", "param2", usedMemory);
		}, JsonUtil.json());
	}
}