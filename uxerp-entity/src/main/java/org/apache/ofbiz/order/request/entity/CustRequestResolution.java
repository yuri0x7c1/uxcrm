package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Resolution
 */
public class CustRequestResolution implements Serializable {

	public static final long serialVersionUID = 8399232622719679488L;
	public static final String NAME = "CustRequestResolution";
	/**
	 * Cust Request Resolution Id
	 */
	@Getter
	@Setter
	private String custRequestResolutionId;
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		custRequestResolutionId, custRequestTypeId, description
	}

	public CustRequestResolution(GenericValue value) {
		custRequestResolutionId = (String) value
				.get(Fields.custRequestResolutionId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CustRequestResolution fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestResolution(value);
	}

	public static List<CustRequestResolution> fromValues(
			List<GenericValue> values) {
		List<CustRequestResolution> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestResolution(value));
		}
		return entities;
	}
}