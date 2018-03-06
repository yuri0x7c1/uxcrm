package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Order
 */
public class CommunicationEventOrder implements Serializable {

	public static final long serialVersionUID = 4920543329692384256L;
	public static final String NAME = "CommunicationEventOrder";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;

	public enum Fields {
		orderId, communicationEventId
	}

	public CommunicationEventOrder(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
	}

	public static CommunicationEventOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventOrder(value);
	}

	public static List<CommunicationEventOrder> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventOrder(value));
		}
		return entities;
	}
}