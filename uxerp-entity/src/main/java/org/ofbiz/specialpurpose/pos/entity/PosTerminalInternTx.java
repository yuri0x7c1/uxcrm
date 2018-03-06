package org.ofbiz.specialpurpose.pos.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pos Terminal Intern Tx
 */
public class PosTerminalInternTx implements Serializable {

	public static final long serialVersionUID = 1158349777195200512L;
	public static final String NAME = "PosTerminalInternTx";
	/**
	 * Pos Terminal Log Id
	 */
	@Getter
	@Setter
	private String posTerminalLogId;
	/**
	 * Paid Amount
	 */
	@Getter
	@Setter
	private BigDecimal paidAmount;
	/**
	 * Reason Comment
	 */
	@Getter
	@Setter
	private String reasonComment;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;

	public enum Fields {
		posTerminalLogId, paidAmount, reasonComment, reasonEnumId
	}

	public PosTerminalInternTx(GenericValue value) {
		posTerminalLogId = (String) value.get(Fields.posTerminalLogId.name());
		paidAmount = (BigDecimal) value.get(Fields.paidAmount.name());
		reasonComment = (String) value.get(Fields.reasonComment.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
	}

	public static PosTerminalInternTx fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PosTerminalInternTx(value);
	}

	public static List<PosTerminalInternTx> fromValues(List<GenericValue> values) {
		List<PosTerminalInternTx> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PosTerminalInternTx(value));
		}
		return entities;
	}
}