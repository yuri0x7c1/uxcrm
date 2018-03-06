package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Cust Request
 */
public class RequirementCustRequest implements Serializable {

	public static final long serialVersionUID = 1558203110216937472L;
	public static final String NAME = "RequirementCustRequest";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;

	public enum Fields {
		custRequestId, custRequestItemSeqId, requirementId
	}

	public RequirementCustRequest(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		requirementId = (String) value.get(Fields.requirementId.name());
	}

	public static RequirementCustRequest fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementCustRequest(value);
	}

	public static List<RequirementCustRequest> fromValues(
			List<GenericValue> values) {
		List<RequirementCustRequest> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementCustRequest(value));
		}
		return entities;
	}
}