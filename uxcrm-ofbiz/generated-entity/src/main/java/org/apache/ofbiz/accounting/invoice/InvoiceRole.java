package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Role
 */
public class InvoiceRole implements Serializable {

	public static final long serialVersionUID = 6489658426106884096L;
	public static final String NAME = "InvoiceRole";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Datetime Performed
	 */
	@Getter
	@Setter
	private Timestamp datetimePerformed;
	/**
	 * Percentage
	 */
	@Getter
	@Setter
	private BigDecimal percentage;
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
		invoiceId, partyId, roleTypeId, datetimePerformed, percentage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceRole(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		datetimePerformed = (Timestamp) value.get(Fields.datetimePerformed
				.name());
		percentage = (BigDecimal) value.get(Fields.percentage.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InvoiceRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceRole(value);
	}

	public static List<InvoiceRole> fromValues(List<GenericValue> values) {
		List<InvoiceRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceRole(value));
		}
		return entities;
	}
}