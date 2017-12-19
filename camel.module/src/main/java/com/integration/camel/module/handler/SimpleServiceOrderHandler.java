package com.integration.camel.module.handler;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.integration.camel.module.to.SimpleServiceOrder;

public class SimpleServiceOrderHandler {

	private List<SimpleServiceOrder> service = new ArrayList<SimpleServiceOrder>();

	public void init() {
		add(new SimpleServiceOrder(1l, "2017-1", "Mogi Guaçu"));
		add(new SimpleServiceOrder(2l, "2017-2", "Limeira"));
	}

	public Response add(SimpleServiceOrder so) {
		service.add(so);

		return Response.created(URI.create("/personservice/person/get/" + so.getId())).build();
	}

	public SimpleServiceOrder getServiceOrderByLabel(String label) {
		SimpleServiceOrder so = service.get(1);
		if (so == null) {
			ResponseBuilder builder = Response.status(Status.NOT_FOUND);
			throw new WebApplicationException(builder.build());
		}

		return so;
	}

	public List<SimpleServiceOrder> getServiceOrderList() {
		if (service == null) {
			ResponseBuilder builder = Response.status(Status.NOT_FOUND);
			throw new WebApplicationException(builder.build());
		}

		return service;
	}

	public Response createNewServiceOrder(SimpleServiceOrder so) {
		return add(so);
	}

}