package com.containersol.minivertx;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class HelloWorld extends AbstractVerticle {


	public static void main(String[] args) throws Exception {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new HelloWorld());
	}

	@Override
	public void start(Future<Void> fut) {
		Router router = Router.router(vertx);

		router.route().handler(BodyHandler.create());
		router.get("/hello").handler(this::hello);

		vertx.createHttpServer()
				.requestHandler(router::accept).listen(8080);
	}

	private void hello(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		response.putHeader("Hello", "Hello there!");
		response.putHeader("content-type", "application/json").end(Json.encodePrettily(new HelloData("p1", "p2")));
	}

	private void sendError(int statusCode, HttpServerResponse response) {
		response.setStatusCode(statusCode).end();
	}
}