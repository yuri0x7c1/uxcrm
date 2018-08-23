package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Product
 */
@FieldNameConstants
public class CommunicationEventProduct implements Serializable {

	public static final long serialVersionUID = 1802211560749611008L;
	public static final String NAME = "CommunicationEventProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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

	public CommunicationEventProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CommunicationEventProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventProduct(value);
	}

	public static List<CommunicationEventProduct> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventProduct(value));
		}
		return entities;
	}
}