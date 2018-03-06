package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Item Work Effort
 */
public class CustRequestItemWorkEffort implements Serializable {

	public static final long serialVersionUID = 6461293956892746752L;
	public static final String NAME = "CustRequestItemWorkEffort";
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
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;

	public enum Fields {
		custRequestId, custRequestItemSeqId, workEffortId
	}

	public CustRequestItemWorkEffort(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
	}

	public static CustRequestItemWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestItemWorkEffort(value);
	}

	public static List<CustRequestItemWorkEffort> fromValues(
			List<GenericValue> values) {
		List<CustRequestItemWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestItemWorkEffort(value));
		}
		return entities;
	}
}