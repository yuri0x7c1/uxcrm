package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Category
 */
public class CustRequestCategory implements Serializable {

	public static final long serialVersionUID = 504176965058372608L;
	public static final String NAME = "CustRequestCategory";
	/**
	 * Cust Request Category Id
	 */
	@Getter
	@Setter
	private String custRequestCategoryId;
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
		custRequestCategoryId, custRequestTypeId, description
	}

	public CustRequestCategory(GenericValue value) {
		custRequestCategoryId = (String) value.get(Fields.custRequestCategoryId
				.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CustRequestCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestCategory(value);
	}

	public static List<CustRequestCategory> fromValues(List<GenericValue> values) {
		List<CustRequestCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestCategory(value));
		}
		return entities;
	}
}