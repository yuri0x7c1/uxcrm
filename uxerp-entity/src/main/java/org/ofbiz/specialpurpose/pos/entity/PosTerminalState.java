package org.ofbiz.specialpurpose.pos.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pos Terminal State
 */
public class PosTerminalState implements Serializable {

	public static final long serialVersionUID = 4126622854816450560L;
	public static final String NAME = "PosTerminalState";
	/**
	 * Pos Terminal Id
	 */
	@Getter
	@Setter
	private String posTerminalId;
	/**
	 * Opened Date
	 */
	@Getter
	@Setter
	private Timestamp openedDate;
	/**
	 * Closed Date
	 */
	@Getter
	@Setter
	private Timestamp closedDate;
	/**
	 * Starting Tx Id
	 */
	@Getter
	@Setter
	private String startingTxId;
	/**
	 * Ending Tx Id
	 */
	@Getter
	@Setter
	private String endingTxId;
	/**
	 * Opened By User Login Id
	 */
	@Getter
	@Setter
	private String openedByUserLoginId;
	/**
	 * Closed By User Login Id
	 */
	@Getter
	@Setter
	private String closedByUserLoginId;
	/**
	 * Starting Drawer Amount
	 */
	@Getter
	@Setter
	private BigDecimal startingDrawerAmount;
	/**
	 * Actual Ending Cash
	 */
	@Getter
	@Setter
	private BigDecimal actualEndingCash;
	/**
	 * Actual Ending Check
	 */
	@Getter
	@Setter
	private BigDecimal actualEndingCheck;
	/**
	 * Actual Ending Cc
	 */
	@Getter
	@Setter
	private BigDecimal actualEndingCc;
	/**
	 * Actual Ending Gc
	 */
	@Getter
	@Setter
	private BigDecimal actualEndingGc;
	/**
	 * Actual Ending Other
	 */
	@Getter
	@Setter
	private BigDecimal actualEndingOther;

	public enum Fields {
		posTerminalId, openedDate, closedDate, startingTxId, endingTxId, openedByUserLoginId, closedByUserLoginId, startingDrawerAmount, actualEndingCash, actualEndingCheck, actualEndingCc, actualEndingGc, actualEndingOther
	}

	public PosTerminalState(GenericValue value) {
		posTerminalId = (String) value.get(Fields.posTerminalId.name());
		openedDate = (Timestamp) value.get(Fields.openedDate.name());
		closedDate = (Timestamp) value.get(Fields.closedDate.name());
		startingTxId = (String) value.get(Fields.startingTxId.name());
		endingTxId = (String) value.get(Fields.endingTxId.name());
		openedByUserLoginId = (String) value.get(Fields.openedByUserLoginId
				.name());
		closedByUserLoginId = (String) value.get(Fields.closedByUserLoginId
				.name());
		startingDrawerAmount = (BigDecimal) value
				.get(Fields.startingDrawerAmount.name());
		actualEndingCash = (BigDecimal) value.get(Fields.actualEndingCash
				.name());
		actualEndingCheck = (BigDecimal) value.get(Fields.actualEndingCheck
				.name());
		actualEndingCc = (BigDecimal) value.get(Fields.actualEndingCc.name());
		actualEndingGc = (BigDecimal) value.get(Fields.actualEndingGc.name());
		actualEndingOther = (BigDecimal) value.get(Fields.actualEndingOther
				.name());
	}

	public static PosTerminalState fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PosTerminalState(value);
	}

	public static List<PosTerminalState> fromValues(List<GenericValue> values) {
		List<PosTerminalState> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PosTerminalState(value));
		}
		return entities;
	}
}