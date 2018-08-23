package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement By Product Facility
 */
@FieldNameConstants
public class RequirementByProductFacility implements Serializable {

	public static final long serialVersionUID = 8752977653101552640L;
	public static final String NAME = "RequirementByProductFacility";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public RequirementByProductFacility(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
	}

	public static RequirementByProductFacility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementByProductFacility(value);
	}

	public static List<RequirementByProductFacility> fromValues(
			List<GenericValue> values) {
		List<RequirementByProductFacility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementByProductFacility(value));
		}
		return entities;
	}
}