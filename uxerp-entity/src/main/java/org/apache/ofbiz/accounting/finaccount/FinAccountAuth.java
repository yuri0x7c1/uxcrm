package org.apache.ofbiz.accounting.finaccount;

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
public class FinAccountAuth implements Serializable {

	public static final long serialVersionUID = 3748211611249687552L;
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

	public enum Fields {
		finAccountAuthId, finAccountId, amount, currencyUomId, authorizationDate, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FinAccountAuth(GenericValue value) {
		finAccountAuthId = (String) value.get(Fields.finAccountAuthId.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		authorizationDate = (Timestamp) value.get(Fields.authorizationDate
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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