package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * E Bay Log Messages Info
 */
public class EBayLogMessagesInfo implements Serializable {

	public static final long serialVersionUID = 8138691812849513472L;
	public static final String NAME = "EBayLogMessagesInfo";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Log Ack
	 */
	@Getter
	@Setter
	private String logAck;
	/**
	 * Function Name
	 */
	@Getter
	@Setter
	private String functionName;
	/**
	 * Log Message
	 */
	@Getter
	@Setter
	private String logMessage;
	/**
	 * Create Datetime
	 */
	@Getter
	@Setter
	private Timestamp createDatetime;

	public enum Fields {
		productStoreId, logAck, functionName, logMessage, createDatetime
	}

	public EBayLogMessagesInfo(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		logAck = (String) value.get(Fields.logAck.name());
		functionName = (String) value.get(Fields.functionName.name());
		logMessage = (String) value.get(Fields.logMessage.name());
		createDatetime = (Timestamp) value.get(Fields.createDatetime.name());
	}

	public static EBayLogMessagesInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EBayLogMessagesInfo(value);
	}

	public static List<EBayLogMessagesInfo> fromValues(List<GenericValue> values) {
		List<EBayLogMessagesInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EBayLogMessagesInfo(value));
		}
		return entities;
	}
}