package org.apache.ofbiz.party.communication;

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
public class CommunicationEventProduct implements Serializable {

	public static final long serialVersionUID = 1878756963788935168L;
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

	public enum Fields {
		productId, communicationEventId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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