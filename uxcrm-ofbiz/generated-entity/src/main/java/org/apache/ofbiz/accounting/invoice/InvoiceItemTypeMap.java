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
 * Invoice Item Type Map
 */
@FieldNameConstants
public class InvoiceItemTypeMap implements Serializable {

	public static final long serialVersionUID = 3182440230086810624L;
	public static final String NAME = "InvoiceItemTypeMap";
	/**
	 * Invoice Item Map Key
	 */
	@Getter
	@Setter
	private String invoiceItemMapKey;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
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

	public InvoiceItemTypeMap(GenericValue value) {
		invoiceItemMapKey = (String) value.get(FIELD_INVOICE_ITEM_MAP_KEY);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceItemTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemTypeMap(value);
	}

	public static List<InvoiceItemTypeMap> fromValues(List<GenericValue> values) {
		List<InvoiceItemTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemTypeMap(value));
		}
		return entities;
	}
}