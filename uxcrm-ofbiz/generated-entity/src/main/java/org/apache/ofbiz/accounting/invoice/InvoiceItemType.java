package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Type
 */
public class InvoiceItemType implements Serializable {

	public static final long serialVersionUID = 1853035545212500992L;
	public static final String NAME = "InvoiceItemType";
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Gl Account Id
	 */
	@Getter
	@Setter
	private String defaultGlAccountId;
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
		invoiceItemTypeId, parentTypeId, hasTable, description, defaultGlAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceItemType(GenericValue value) {
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		defaultGlAccountId = (String) value.get(Fields.defaultGlAccountId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InvoiceItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemType(value);
	}

	public static List<InvoiceItemType> fromValues(List<GenericValue> values) {
		List<InvoiceItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemType(value));
		}
		return entities;
	}
}