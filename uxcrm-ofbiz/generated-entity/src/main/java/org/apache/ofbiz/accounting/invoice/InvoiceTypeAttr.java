package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Type Attr
 */
public class InvoiceTypeAttr implements Serializable {

	public static final long serialVersionUID = 3659997048967435264L;
	public static final String NAME = "InvoiceTypeAttr";
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		invoiceTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceTypeAttr(GenericValue value) {
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InvoiceTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceTypeAttr(value);
	}

	public static List<InvoiceTypeAttr> fromValues(List<GenericValue> values) {
		List<InvoiceTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceTypeAttr(value));
		}
		return entities;
	}
}