package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account Term Attr
 */
@FieldNameConstants
public class BillingAccountTermAttr implements Serializable {

	public static final long serialVersionUID = 1819206617953755136L;
	public static final String NAME = "BillingAccountTermAttr";
	/**
	 * Billing Account Term Id
	 */
	@Getter
	@Setter
	private String billingAccountTermId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
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

	public BillingAccountTermAttr(GenericValue value) {
		billingAccountTermId = (String) value
				.get(FIELD_BILLING_ACCOUNT_TERM_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BillingAccountTermAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountTermAttr(value);
	}

	public static List<BillingAccountTermAttr> fromValues(
			List<GenericValue> values) {
		List<BillingAccountTermAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountTermAttr(value));
		}
		return entities;
	}
}