package org.apache.ofbiz.accounting.finaccount;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans Sum
 */
@FieldNameConstants
public class FinAccountTransSum implements Serializable {

	public static final long serialVersionUID = 4233955240423416832L;
	public static final String NAME = "FinAccountTransSum";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Fin Account Trans Type Id
	 */
	@Getter
	@Setter
	private String finAccountTransTypeId;
	/**
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public FinAccountTransSum(GenericValue value) {
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		finAccountTransTypeId = (String) value
				.get(FIELD_FIN_ACCOUNT_TRANS_TYPE_ID);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
	}

	public static FinAccountTransSum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTransSum(value);
	}

	public static List<FinAccountTransSum> fromValues(List<GenericValue> values) {
		List<FinAccountTransSum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTransSum(value));
		}
		return entities;
	}
}