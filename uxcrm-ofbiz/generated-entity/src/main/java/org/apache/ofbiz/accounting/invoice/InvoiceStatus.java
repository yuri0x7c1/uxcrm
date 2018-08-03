package org.apache.ofbiz.accounting.invoice;

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
public class InvoiceStatus implements Serializable {

	public static final long serialVersionUID = 4765914187514631168L;
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

	public enum Fields {
		statusId, invoiceId, statusDate, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceStatus(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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