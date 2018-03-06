package org.apache.ofbiz.shipment.receipt.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rejection Reason
 */
public class RejectionReason implements Serializable {

	public static final long serialVersionUID = 8069035569549018112L;
	public static final String NAME = "RejectionReason";
	/**
	 * Rejection Id
	 */
	@Getter
	@Setter
	private String rejectionId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		rejectionId, description
	}

	public RejectionReason(GenericValue value) {
		rejectionId = (String) value.get(Fields.rejectionId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RejectionReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RejectionReason(value);
	}

	public static List<RejectionReason> fromValues(List<GenericValue> values) {
		List<RejectionReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RejectionReason(value));
		}
		return entities;
	}
}