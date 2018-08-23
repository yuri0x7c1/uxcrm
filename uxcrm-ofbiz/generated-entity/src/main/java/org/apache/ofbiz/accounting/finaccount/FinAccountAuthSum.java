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
 * Fin Account Auth Sum
 */
@FieldNameConstants
public class FinAccountAuthSum implements Serializable {

	public static final long serialVersionUID = 3872139134249808896L;
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

	public FinAccountAuthSum(GenericValue value) {
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		authorizationDate = (Timestamp) value.get(FIELD_AUTHORIZATION_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
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