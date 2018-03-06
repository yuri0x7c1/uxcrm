package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Product
 */
public class CommunicationEventProduct implements Serializable {

	public static final long serialVersionUID = 6616778851998385152L;
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

	public enum Fields {
		productId, communicationEventId
	}

	public CommunicationEventProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
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