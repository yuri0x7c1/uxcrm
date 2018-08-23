package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProtocolType implements Serializable {

	public static final long serialVersionUID = 6855649020894508032L;
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

	public ProtocolType(GenericValue value) {
		protocolTypeId = (String) value.get(FIELD_PROTOCOL_TYPE_ID);
		protocolName = (String) value.get(FIELD_PROTOCOL_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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