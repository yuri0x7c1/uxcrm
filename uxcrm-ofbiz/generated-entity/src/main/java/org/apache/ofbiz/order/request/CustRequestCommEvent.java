package org.apache.ofbiz.order.request;

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
public class CustRequestCommEvent implements Serializable {

	public static final long serialVersionUID = 362900780394424320L;
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

	public enum Fields {
		custRequestId, communicationEventId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestCommEvent(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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