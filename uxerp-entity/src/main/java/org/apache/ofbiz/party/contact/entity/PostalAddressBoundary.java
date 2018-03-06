package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Postal Address Boundary
 */
public class PostalAddressBoundary implements Serializable {

	public static final long serialVersionUID = 6382881545196427264L;
	public static final String NAME = "PostalAddressBoundary";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;

	public enum Fields {
		contactMechId, geoId
	}

	public PostalAddressBoundary(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		geoId = (String) value.get(Fields.geoId.name());
	}

	public static PostalAddressBoundary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PostalAddressBoundary(value);
	}

	public static List<PostalAddressBoundary> fromValues(
			List<GenericValue> values) {
		List<PostalAddressBoundary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PostalAddressBoundary(value));
		}
		return entities;
	}
}