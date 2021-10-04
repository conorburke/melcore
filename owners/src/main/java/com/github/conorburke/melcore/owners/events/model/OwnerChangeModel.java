package com.github.conorburke.melcore.owners.events.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OwnerChangeModel {
	private String type;
	private String action;
	private String ownerId;
	private String correlationId;

	public OwnerChangeModel(String type, String action, String ownerId, String correlationId) {
		super();
		this.type = type;
		this.action = action;
		this.ownerId = ownerId;
		this.correlationId = correlationId;
	}
}