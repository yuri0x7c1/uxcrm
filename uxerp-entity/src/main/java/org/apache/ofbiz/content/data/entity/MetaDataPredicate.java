package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Meta Data Predicate
 */
public class MetaDataPredicate implements Serializable {

	public static final long serialVersionUID = 2535474503864061952L;
	public static final String NAME = "MetaDataPredicate";
	/**
	 * Meta Data Predicate Id
	 */
	@Getter
	@Setter
	private String metaDataPredicateId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		metaDataPredicateId, description
	}

	public MetaDataPredicate(GenericValue value) {
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static MetaDataPredicate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MetaDataPredicate(value);
	}

	public static List<MetaDataPredicate> fromValues(List<GenericValue> values) {
		List<MetaDataPredicate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MetaDataPredicate(value));
		}
		return entities;
	}
}