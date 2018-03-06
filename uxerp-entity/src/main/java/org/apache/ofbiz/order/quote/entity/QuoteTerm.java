package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Term
 */
public class QuoteTerm implements Serializable {

	public static final long serialVersionUID = 2188518833000111104L;
	public static final String NAME = "QuoteTerm";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Quote Item Seq Id
	 */
	@Getter
	@Setter
	private String quoteItemSeqId;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private Long termValue;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public enum Fields {
		termTypeId, quoteId, quoteItemSeqId, termValue, uomId, termDays, textValue, description
	}

	public QuoteTerm(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		quoteItemSeqId = (String) value.get(Fields.quoteItemSeqId.name());
		termValue = (Long) value.get(Fields.termValue.name());
		uomId = (String) value.get(Fields.uomId.name());
		termDays = (Long) value.get(Fields.termDays.name());
		textValue = (String) value.get(Fields.textValue.name());
		description = (String) value.get(Fields.description.name());
	}

	public static QuoteTerm fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteTerm(value);
	}

	public static List<QuoteTerm> fromValues(List<GenericValue> values) {
		List<QuoteTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteTerm(value));
		}
		return entities;
	}
}