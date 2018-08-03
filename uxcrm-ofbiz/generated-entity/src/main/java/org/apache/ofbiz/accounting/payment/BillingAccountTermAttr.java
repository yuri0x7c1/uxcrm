package org.apache.ofbiz.accounting.payment;

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
public class BillingAccountTermAttr implements Serializable {

	public static final long serialVersionUID = 3097865185430243328L;
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

	public enum Fields {
		billingAccountTermId, attrName, attrValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BillingAccountTermAttr(GenericValue value) {
		billingAccountTermId = (String) value.get(Fields.billingAccountTermId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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