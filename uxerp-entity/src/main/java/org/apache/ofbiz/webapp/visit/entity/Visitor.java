package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visitor
 */
public class Visitor implements Serializable {

	public static final long serialVersionUID = 6774914825407990784L;
	public static final String NAME = "Visitor";
	/**
	 * Visitor Id
	 */
	@Getter
	@Setter
	private String visitorId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;

	public enum Fields {
		visitorId, userLoginId
	}

	public Visitor(GenericValue value) {
		visitorId = (String) value.get(Fields.visitorId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
	}

	public static Visitor fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Visitor(value);
	}

	public static List<Visitor> fromValues(List<GenericValue> values) {
		List<Visitor> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Visitor(value));
		}
		return entities;
	}
}