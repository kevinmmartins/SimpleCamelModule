package com.integration.camel.module.handler;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.integration.camel.module.to.SimpleServiceOrder;

public class SimpleServiceOrderHandler {

	private Map<Integer, SimpleServiceOrder> service = new HashMap<Integer, SimpleServiceOrder>();

	public void init() {
		add(new SimpleServiceOrder(1l, "2017-1", "Mogi Guaçu"));
	}

	private Response add(SimpleServiceOrder so) {
		service.put(so.getId().intValue(), so);

		return Response.created(URI.create("/personservice/person/get/" + so.getId())).build();
	}

	private SimpleServiceOrder getServiceOrderByLabel(int id) {
		SimpleServiceOrder so = service.get(id);
		if (so == null) {
			ResponseBuilder builder = Response.status(Status.NOT_FOUND);
			throw new WebApplicationException(builder.build());
		}

		return so;
	}

	private Collection<SimpleServiceOrder> getServiceOrderList() {
		if (service == null) {
			ResponseBuilder builder = Response.status(Status.NOT_FOUND);
			throw new WebApplicationException(builder.build());
		}

		return service.values();
	}

	public Response createNewServiceOrder(SimpleServiceOrder so) {
		return add(so);
	}

}