package com.containersol.minivertx;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		port(8080);
		get("/hello", (request, response) -> new HelloData("param1", "param2"), JsonUtil.json());
	}
}