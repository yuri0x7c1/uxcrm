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
 * Invoice Item Type Attr
 */
@FieldNameConstants
public class InvoiceItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 5723707820710567936L;
	public static final String NAME = "InvoiceItemTypeAttr";
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
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

	public InvoiceItemTypeAttr(GenericValue value) {
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemTypeAttr(value);
	}

	public static List<InvoiceItemTypeAttr> fromValues(List<GenericValue> values) {
		List<InvoiceItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemTypeAttr(value));
		}
		return entities;
	}
}