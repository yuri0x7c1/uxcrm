package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Term Type Attr
 */
public class TermTypeAttr implements Serializable {

	public static final long serialVersionUID = 5069006360252104704L;
	public static final String NAME = "TermTypeAttr";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		termTypeId, attrName, description
	}

	public TermTypeAttr(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TermTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TermTypeAttr(value);
	}

	public static List<TermTypeAttr> fromValues(List<GenericValue> values) {
		List<TermTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TermTypeAttr(value));
		}
		return entities;
	}
}