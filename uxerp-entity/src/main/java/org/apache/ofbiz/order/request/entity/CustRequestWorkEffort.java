package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Work Effort
 */
public class CustRequestWorkEffort implements Serializable {

	public static final long serialVersionUID = 3634463702358805504L;
	public static final String NAME = "CustRequestWorkEffort";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;

	public enum Fields {
		custRequestId, workEffortId
	}

	public CustRequestWorkEffort(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
	}

	public static CustRequestWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestWorkEffort(value);
	}

	public static List<CustRequestWorkEffort> fromValues(
			List<GenericValue> values) {
		List<CustRequestWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestWorkEffort(value));
		}
		return entities;
	}
}