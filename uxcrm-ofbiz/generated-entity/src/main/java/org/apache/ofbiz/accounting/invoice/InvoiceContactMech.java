package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Contact Mech
 */
public class InvoiceContactMech implements Serializable {

	public static final long serialVersionUID = 158398736869591040L;
	public static final String NAME = "InvoiceContactMech";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
		invoiceId, contactMechPurposeTypeId, contactMechId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceContactMech(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InvoiceContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceContactMech(value);
	}

	public static List<InvoiceContactMech> fromValues(List<GenericValue> values) {
		List<InvoiceContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceContactMech(value));
		}
		return entities;
	}
}