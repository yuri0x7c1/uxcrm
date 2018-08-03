package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Work Effort
 */
public class CustRequestWorkEffort implements Serializable {

	public static final long serialVersionUID = 235741576827368448L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		custRequestId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestWorkEffort(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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