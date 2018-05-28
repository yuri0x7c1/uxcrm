package org.apache.ofbiz.accounting.finaccount;

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
public class FinAccountTransSum implements Serializable {

	public static final long serialVersionUID = 2875307586924090368L;
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

	public enum Fields {
		finAccountId, finAccountTransTypeId, transactionDate, amount
	}

	public FinAccountTransSum(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		finAccountTransTypeId = (String) value.get(Fields.finAccountTransTypeId
				.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
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