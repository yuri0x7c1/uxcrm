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
 * Cust Request Comm Event
 */
@FieldNameConstants
public class CustRequestCommEvent implements Serializable {

	public static final long serialVersionUID = 496914286722046976L;
	public static final String NAME = "CustRequestCommEvent";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
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

	public CustRequestCommEvent(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestCommEvent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestCommEvent(value);
	}

	public static List<CustRequestCommEvent> fromValues(
			List<GenericValue> values) {
		List<CustRequestCommEvent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestCommEvent(value));
		}
		return entities;
	}
}