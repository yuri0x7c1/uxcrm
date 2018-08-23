package org.apache.ofbiz.accounting.finaccount;

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
 * Fin Account Auth
 */
@FieldNameConstants
public class FinAccountAuth implements Serializable {

	public static final long serialVersionUID = 6575365942326998016L;
	public static final String NAME = "FinAccountAuth";
	/**
	 * Fin Account Auth Id
	 */
	@Getter
	@Setter
	private String finAccountAuthId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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

	public FinAccountAuth(GenericValue value) {
		finAccountAuthId = (String) value.get(FIELD_FIN_ACCOUNT_AUTH_ID);
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		authorizationDate = (Timestamp) value.get(FIELD_AUTHORIZATION_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FinAccountAuth fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountAuth(value);
	}

	public static List<FinAccountAuth> fromValues(List<GenericValue> values) {
		List<FinAccountAuth> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountAuth(value));
		}
		return entities;
	}
}