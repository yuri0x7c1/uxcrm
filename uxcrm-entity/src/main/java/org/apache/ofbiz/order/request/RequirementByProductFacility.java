package org.apache.ofbiz.order.request;

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
public class RequirementByProductFacility implements Serializable {

	public static final long serialVersionUID = 98263848623854592L;
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

	public enum Fields {
		statusId, productId, facilityId, quantity
	}

	public RequirementByProductFacility(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
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