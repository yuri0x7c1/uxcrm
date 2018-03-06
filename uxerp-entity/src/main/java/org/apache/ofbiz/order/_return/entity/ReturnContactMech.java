package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Contact Mech
 */
public class ReturnContactMech implements Serializable {

	public static final long serialVersionUID = 7710573014520910848L;
	public static final String NAME = "ReturnContactMech";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		returnId, contactMechPurposeTypeId, contactMechId
	}

	public ReturnContactMech(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static ReturnContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnContactMech(value);
	}

	public static List<ReturnContactMech> fromValues(List<GenericValue> values) {
		List<ReturnContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnContactMech(value));
		}
		return entities;
	}
}