package org.apache.ofbiz.party.agreement;

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
 * Agreement Term
 */
@FieldNameConstants
public class AgreementTerm implements Serializable {

	public static final long serialVersionUID = 2274001931462549504L;
	public static final String NAME = "AgreementTerm";
	/**
	 * Agreement Term Id
	 */
	@Getter
	@Setter
	private String agreementTermId;
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
	 * Min Quantity
	 */
	@Getter
	@Setter
	private Double minQuantity;
	/**
	 * Max Quantity
	 */
	@Getter
	@Setter
	private Double maxQuantity;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public AgreementTerm(GenericValue value) {
		agreementTermId = (String) value.get(FIELD_AGREEMENT_TERM_ID);
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		termValue = (BigDecimal) value.get(FIELD_TERM_VALUE);
		termDays = (Long) value.get(FIELD_TERM_DAYS);
		textValue = (String) value.get(FIELD_TEXT_VALUE);
		minQuantity = (Double) value.get(FIELD_MIN_QUANTITY);
		maxQuantity = (Double) value.get(FIELD_MAX_QUANTITY);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AgreementTerm fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementTerm(value);
	}

	public static List<AgreementTerm> fromValues(List<GenericValue> values) {
		List<AgreementTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementTerm(value));
		}
		return entities;
	}
}