package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Type
 */
public class CustRequestType implements Serializable {

	public static final long serialVersionUID = 582517651069371392L;
	public static final String NAME = "CustRequestType";
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public enum Fields {
		custRequestTypeId, parentTypeId, hasTable, description, partyId
	}

	public CustRequestType(GenericValue value) {
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static CustRequestType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestType(value);
	}

	public static List<CustRequestType> fromValues(List<GenericValue> values) {
		List<CustRequestType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestType(value));
		}
		return entities;
	}
}