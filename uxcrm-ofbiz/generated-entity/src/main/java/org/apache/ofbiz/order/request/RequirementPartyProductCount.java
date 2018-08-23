package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Party Product Count
 */
@FieldNameConstants
public class RequirementPartyProductCount implements Serializable {

	public static final long serialVersionUID = 3277064361881428992L;
	public static final String NAME = "RequirementPartyProductCount";
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
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
	private Long productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public RequirementPartyProductCount(GenericValue value) {
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		productId = (Long) value.get(FIELD_PRODUCT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static RequirementPartyProductCount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementPartyProductCount(value);
	}

	public static List<RequirementPartyProductCount> fromValues(
			List<GenericValue> values) {
		List<RequirementPartyProductCount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementPartyProductCount(value));
		}
		return entities;
	}
}