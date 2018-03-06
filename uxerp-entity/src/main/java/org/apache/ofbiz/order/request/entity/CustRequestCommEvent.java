package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Comm Event
 */
public class CustRequestCommEvent implements Serializable {

	public static final long serialVersionUID = 4995788329730213888L;
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

	public enum Fields {
		custRequestId, communicationEventId
	}

	public CustRequestCommEvent(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
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