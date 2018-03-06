package org.ofbiz.specialpurpose.pos.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pos Terminal Log
 */
public class PosTerminalLog implements Serializable {

	public static final long serialVersionUID = 6244623925750124544L;
	public static final String NAME = "PosTerminalLog";
	/**
	 * Pos Terminal Log Id
	 */
	@Getter
	@Setter
	private String posTerminalLogId;
	/**
	 * Pos Terminal Id
	 */
	@Getter
	@Setter
	private String posTerminalId;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
	/**
	 * Item Count
	 */
	@Getter
	@Setter
	private Long itemCount;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Log Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp logStartDateTime;
	/**
	 * Log End Date Time
	 */
	@Getter
	@Setter
	private Timestamp logEndDateTime;

	public enum Fields {
		posTerminalLogId, posTerminalId, transactionId, itemCount, orderId, returnId, userLoginId, statusId, logStartDateTime, logEndDateTime
	}

	public PosTerminalLog(GenericValue value) {
		posTerminalLogId = (String) value.get(Fields.posTerminalLogId.name());
		posTerminalId = (String) value.get(Fields.posTerminalId.name());
		transactionId = (String) value.get(Fields.transactionId.name());
		itemCount = (Long) value.get(Fields.itemCount.name());
		orderId = (String) value.get(Fields.orderId.name());
		returnId = (String) value.get(Fields.returnId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		statusId = (String) value.get(Fields.statusId.name());
		logStartDateTime = (Timestamp) value
				.get(Fields.logStartDateTime.name());
		logEndDateTime = (Timestamp) value.get(Fields.logEndDateTime.name());
	}

	public static PosTerminalLog fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PosTerminalLog(value);
	}

	public static List<PosTerminalLog> fromValues(List<GenericValue> values) {
		List<PosTerminalLog> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PosTerminalLog(value));
		}
		return entities;
	}
}