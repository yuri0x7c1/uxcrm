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
 * Cust Request Work Effort
 */
@FieldNameConstants
public class CustRequestWorkEffort implements Serializable {

	public static final long serialVersionUID = 538945359581657088L;
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

	public CustRequestWorkEffort(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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