package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class InvoiceRole implements Serializable {

	public static final long serialVersionUID = 5135105152801730560L;
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

	public InvoiceRole(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		datetimePerformed = (Timestamp) value.get(FIELD_DATETIME_PERFORMED);
		percentage = (BigDecimal) value.get(FIELD_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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