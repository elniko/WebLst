package com.ubpartner.lunch;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

	    

	    WebAppContext root = new WebAppContext("WebLst", "/");
	  	server.setHandler(root);

	    server.start();
	    server.join();
	}

}
