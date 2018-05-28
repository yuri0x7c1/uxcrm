package org.apache.ofbiz.webapp.visit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Protocol Type
 */
public class ProtocolType implements Serializable {

	public static final long serialVersionUID = 2335387864775567360L;
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
		protocolTypeId, protocolName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProtocolType(GenericValue value) {
		protocolTypeId = (String) value.get(Fields.protocolTypeId.name());
		protocolName = (String) value.get(Fields.protocolName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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