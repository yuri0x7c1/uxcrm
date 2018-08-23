package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContentAssocPredicate implements Serializable {

	public static final long serialVersionUID = 8111011248414733312L;
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

	public ContentAssocPredicate(GenericValue value) {
		contentAssocPredicateId = (String) value
				.get(FIELD_CONTENT_ASSOC_PREDICATE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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