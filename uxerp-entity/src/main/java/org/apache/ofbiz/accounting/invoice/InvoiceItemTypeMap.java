package org.apache.ofbiz.accounting.invoice;

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
public class InvoiceItemTypeMap implements Serializable {

	public static final long serialVersionUID = 8933929372600471552L;
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

	public enum Fields {
		invoiceItemMapKey, invoiceTypeId, invoiceItemTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceItemTypeMap(GenericValue value) {
		invoiceItemMapKey = (String) value.get(Fields.invoiceItemMapKey.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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