package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Protocol Type
 */
public class ProtocolType implements Serializable {

	public static final long serialVersionUID = 5317938290092174336L;
	public static final String NAME = "ProtocolType";
	/**
	 * Protocol Type Id
	 */
	@Getter
	@Setter
	private String protocolTypeId;
	/**
	 * Protocol Name
	 */
	@Getter
	@Setter
	private String protocolName;

	public enum Fields {
		protocolTypeId, protocolName
	}

	public ProtocolType(GenericValue value) {
		protocolTypeId = (String) value.get(Fields.protocolTypeId.name());
		protocolName = (String) value.get(Fields.protocolName.name());
	}

	public static ProtocolType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProtocolType(value);
	}

	public static List<ProtocolType> fromValues(List<GenericValue> values) {
		List<ProtocolType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProtocolType(value));
		}
		return entities;
	}
}