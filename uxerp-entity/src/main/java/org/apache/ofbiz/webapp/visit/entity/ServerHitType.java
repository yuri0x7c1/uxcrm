package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Server Hit Type
 */
public class ServerHitType implements Serializable {

	public static final long serialVersionUID = 3452597376078533632L;
	public static final String NAME = "ServerHitType";
	/**
	 * Hit Type Id
	 */
	@Getter
	@Setter
	private String hitTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		hitTypeId, description
	}

	public ServerHitType(GenericValue value) {
		hitTypeId = (String) value.get(Fields.hitTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ServerHitType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ServerHitType(value);
	}

	public static List<ServerHitType> fromValues(List<GenericValue> values) {
		List<ServerHitType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ServerHitType(value));
		}
		return entities;
	}
}