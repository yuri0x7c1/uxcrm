package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Attribute
 */
public class InvoiceAttribute implements Serializable {

	public static final long serialVersionUID = 6514117823333360640L;
	public static final String NAME = "InvoiceAttribute";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
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

	public enum Fields {
		invoiceId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceAttribute(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InvoiceAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceAttribute(value);
	}

	public static List<InvoiceAttribute> fromValues(List<GenericValue> values) {
		List<InvoiceAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceAttribute(value));
		}
		return entities;
	}
}