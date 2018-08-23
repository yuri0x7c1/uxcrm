package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Term
 */
@FieldNameConstants
public class InvoiceTerm implements Serializable {

	public static final long serialVersionUID = 5672488658929951744L;
	public static final String NAME = "InvoiceTerm";
	/**
	 * Invoice Term Id
	 */
	@Getter
	@Setter
	private String invoiceTermId;
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private BigDecimal termValue;
	/**
	 * Term Days
	 */
	@Getter
	@Setter
	private Long termDays;
	/**
	 * Text Value
	 */
	@Getter
	@Setter
	private String textValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public InvoiceTerm(GenericValue value) {
		invoiceTermId = (String) value.get(FIELD_INVOICE_TERM_ID);
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		termValue = (BigDecimal) value.get(FIELD_TERM_VALUE);
		termDays = (Long) value.get(FIELD_TERM_DAYS);
		textValue = (String) value.get(FIELD_TEXT_VALUE);
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceTerm fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceTerm(value);
	}

	public static List<InvoiceTerm> fromValues(List<GenericValue> values) {
		List<InvoiceTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceTerm(value));
		}
		return entities;
	}
}