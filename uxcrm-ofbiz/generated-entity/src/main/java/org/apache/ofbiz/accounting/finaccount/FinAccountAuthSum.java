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
 * Fin Account Auth Sum
 */
public class FinAccountAuthSum implements Serializable {

	public static final long serialVersionUID = 9150471858452929536L;
	public static final String NAME = "FinAccountAuthSum";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Authorization Date
	 */
	@Getter
	@Setter
	private Timestamp authorizationDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public enum Fields {
		finAccountId, authorizationDate, fromDate, thruDate, amount
	}

	public FinAccountAuthSum(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		authorizationDate = (Timestamp) value.get(Fields.authorizationDate
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static FinAccountAuthSum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountAuthSum(value);
	}

	public static List<FinAccountAuthSum> fromValues(List<GenericValue> values) {
		List<FinAccountAuthSum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountAuthSum(value));
		}
		return entities;
	}
}