package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Term Attribute
 */
public class QuoteTermAttribute implements Serializable {

	public static final long serialVersionUID = 7021563310210379776L;
	public static final String NAME = "QuoteTermAttribute";
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
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		termTypeId, quoteId, quoteItemSeqId, attrName, attrValue, attrDescription
	}

	public QuoteTermAttribute(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		quoteItemSeqId = (String) value.get(Fields.quoteItemSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static QuoteTermAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteTermAttribute(value);
	}

	public static List<QuoteTermAttribute> fromValues(List<GenericValue> values) {
		List<QuoteTermAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteTermAttribute(value));
		}
		return entities;
	}
}