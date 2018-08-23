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
 * Billing Account Term
 */
@FieldNameConstants
public class BillingAccountTerm implements Serializable {

	public static final long serialVersionUID = 5264756201265277952L;
	public static final String NAME = "BillingAccountTerm";
	/**
	 * Billing Account Term Id
	 */
	@Getter
	@Setter
	private String billingAccountTermId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private BigDecimal termValue;
	/**
	 * Term Days
	 */
	@Getter
	@Setter
	private Long termDays;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public BillingAccountTerm(GenericValue value) {
		billingAccountTermId = (String) value
				.get(FIELD_BILLING_ACCOUNT_TERM_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		termValue = (BigDecimal) value.get(FIELD_TERM_VALUE);
		termDays = (Long) value.get(FIELD_TERM_DAYS);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BillingAccountTerm fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountTerm(value);
	}

	public static List<BillingAccountTerm> fromValues(List<GenericValue> values) {
		List<BillingAccountTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountTerm(value));
		}
		return entities;
	}
}