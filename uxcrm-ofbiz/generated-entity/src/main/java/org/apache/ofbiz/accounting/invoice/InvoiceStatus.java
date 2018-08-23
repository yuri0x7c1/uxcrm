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
 * Invoice Status
 */
@FieldNameConstants
public class InvoiceStatus implements Serializable {

	public static final long serialVersionUID = 5993604103801745408L;
	public static final String NAME = "InvoiceStatus";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public InvoiceStatus(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceStatus(value);
	}

	public static List<InvoiceStatus> fromValues(List<GenericValue> values) {
		List<InvoiceStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceStatus(value));
		}
		return entities;
	}
}