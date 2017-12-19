package com.integration.camel.module.to;

import java.io.Serializable;

public class SimpleServiceOrder implements Serializable {

	/**
	 * Always change after make some change
	 */
	private static final long serialVersionUID = -1016842559380403643L;
	private Long id;
	private String label;
	private String hierarchy;

	public SimpleServiceOrder() {

	}

	public SimpleServiceOrder(Long id, String label, String hierarchy) {
		super();
		this.id = id;
		this.label = label;
		this.hierarchy = hierarchy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

}
