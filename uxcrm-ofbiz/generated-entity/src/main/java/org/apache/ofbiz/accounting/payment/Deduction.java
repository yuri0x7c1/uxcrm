package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deduction
 */
public class Deduction implements Serializable {

	public static final long serialVersionUID = 202123135685337088L;
	public static final String NAME = "Deduction";
	/**
	 * Deduction Id
	 */
	@Getter
	@Setter
	private String deductionId;
	/**
	 * Deduction Type Id
	 */
	@Getter
	@Setter
	private String deductionTypeId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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
		deductionId, deductionTypeId, paymentId, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Deduction(GenericValue value) {
		deductionId = (String) value.get(Fields.deductionId.name());
		deductionTypeId = (String) value.get(Fields.deductionTypeId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Deduction fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Deduction(value);
	}

	public static List<Deduction> fromValues(List<GenericValue> values) {
		List<Deduction> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Deduction(value));
		}
		return entities;
	}
}