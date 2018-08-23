package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Meta Data Predicate
 */
@FieldNameConstants
public class MetaDataPredicate implements Serializable {

	public static final long serialVersionUID = 8456275024558909440L;
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

	public MetaDataPredicate(GenericValue value) {
		metaDataPredicateId = (String) value.get(FIELD_META_DATA_PREDICATE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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