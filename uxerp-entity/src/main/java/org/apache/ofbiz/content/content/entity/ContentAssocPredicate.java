package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Predicate
 */
public class ContentAssocPredicate implements Serializable {

	public static final long serialVersionUID = 3807466610421628928L;
	public static final String NAME = "ContentAssocPredicate";
	/**
	 * Content Assoc Predicate Id
	 */
	@Getter
	@Setter
	private String contentAssocPredicateId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contentAssocPredicateId, description
	}

	public ContentAssocPredicate(GenericValue value) {
		contentAssocPredicateId = (String) value
				.get(Fields.contentAssocPredicateId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentAssocPredicate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocPredicate(value);
	}

	public static List<ContentAssocPredicate> fromValues(
			List<GenericValue> values) {
		List<ContentAssocPredicate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocPredicate(value));
		}
		return entities;
	}
}