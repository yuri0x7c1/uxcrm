package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Predicate
 */
public class ContentAssocPredicate implements Serializable {

	public static final long serialVersionUID = 4918552209496630272L;
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

	public enum Fields {
		contentAssocPredicateId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentAssocPredicate(GenericValue value) {
		contentAssocPredicateId = (String) value
				.get(Fields.contentAssocPredicateId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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