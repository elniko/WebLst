package com.ubpartner.webresources;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//@Provider
//@Produces({"text/json", MediaType.APPLICATION_JSON})
public class EntityProvider<T> implements MessageBodyWriter<T>{

	

	@Override
	public long getSize(T arg0, Class<?> arg1, Type arg2, Annotation[] arg3,
			MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		return true;
	}

	@Override
	public void writeTo(T arg0, Class<?> arg1, Type arg2, Annotation[] arg3,
			MediaType arg4, MultivaluedMap<String, Object> arg5,
			OutputStream arg6) throws IOException, WebApplicationException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(arg0);
        arg6.write(json.getBytes());
	}

}
