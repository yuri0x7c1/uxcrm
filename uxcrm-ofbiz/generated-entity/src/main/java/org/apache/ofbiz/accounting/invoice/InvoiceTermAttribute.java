package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Term Attribute
 */
@FieldNameConstants
public class InvoiceTermAttribute implements Serializable {

	public static final long serialVersionUID = 8309935733832290304L;
	public static final String NAME = "InvoiceTermAttribute";
	/**
	 * Invoice Term Id
	 */
	@Getter
	@Setter
	private String invoiceTermId;
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
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public InvoiceTermAttribute(GenericValue value) {
		invoiceTermId = (String) value.get(FIELD_INVOICE_TERM_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceTermAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceTermAttribute(value);
	}

	public static List<InvoiceTermAttribute> fromValues(
			List<GenericValue> values) {
		List<InvoiceTermAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceTermAttribute(value));
		}
		return entities;
	}
}