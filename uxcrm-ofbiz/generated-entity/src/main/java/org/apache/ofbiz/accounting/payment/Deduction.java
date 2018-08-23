package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Deduction implements Serializable {

	public static final long serialVersionUID = 2885854144216552448L;
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

	public Deduction(GenericValue value) {
		deductionId = (String) value.get(FIELD_DEDUCTION_ID);
		deductionTypeId = (String) value.get(FIELD_DEDUCTION_TYPE_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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