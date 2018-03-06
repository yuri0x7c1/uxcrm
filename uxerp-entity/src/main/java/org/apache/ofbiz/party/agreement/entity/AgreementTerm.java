package org.apache.ofbiz.party.agreement.entity;

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
public class AgreementTerm implements Serializable {

	public static final long serialVersionUID = 3942817178599854080L;
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

	public enum Fields {
		agreementTermId, termTypeId, agreementId, agreementItemSeqId, invoiceItemTypeId, fromDate, thruDate, termValue, termDays, textValue, minQuantity, maxQuantity, description
	}

	public AgreementTerm(GenericValue value) {
		agreementTermId = (String) value.get(Fields.agreementTermId.name());
		termTypeId = (String) value.get(Fields.termTypeId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		termValue = (BigDecimal) value.get(Fields.termValue.name());
		termDays = (Long) value.get(Fields.termDays.name());
		textValue = (String) value.get(Fields.textValue.name());
		minQuantity = (Double) value.get(Fields.minQuantity.name());
		maxQuantity = (Double) value.get(Fields.maxQuantity.name());
		description = (String) value.get(Fields.description.name());
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