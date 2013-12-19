package com.fave100.samples.rpc.server;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fave100.samples.rpc.client.PersonService;
import com.googlecode.jsonrpc4j.JsonRpcServer;

@SuppressWarnings("serial")
public class PersonJsonRpcServlet extends HttpServlet {
	
	private PersonService faveItemService;
	private JsonRpcServer jsonRpcServer;
		
	public void init(ServletConfig config) {
		this.faveItemService = new PersonServiceImpl();
		this.jsonRpcServer = new JsonRpcServer(this.faveItemService, PersonService.class);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		jsonRpcServer.handle(req, resp);
	}
	
}