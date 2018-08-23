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
 * Invoice Contact Mech
 */
@FieldNameConstants
public class InvoiceContactMech implements Serializable {

	public static final long serialVersionUID = 7309305489404266496L;
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

	public InvoiceContactMech(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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