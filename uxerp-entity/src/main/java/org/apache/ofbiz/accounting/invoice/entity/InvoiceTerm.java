package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Term
 */
public class InvoiceTerm implements Serializable {

	public static final long serialVersionUID = 3606817794725097472L;
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

	public enum Fields {
		invoiceTermId, termTypeId, invoiceId, invoiceItemSeqId, termValue, termDays, textValue, description, uomId
	}

	public InvoiceTerm(GenericValue value) {
		invoiceTermId = (String) value.get(Fields.invoiceTermId.name());
		termTypeId = (String) value.get(Fields.termTypeId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		termValue = (BigDecimal) value.get(Fields.termValue.name());
		termDays = (Long) value.get(Fields.termDays.name());
		textValue = (String) value.get(Fields.textValue.name());
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
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