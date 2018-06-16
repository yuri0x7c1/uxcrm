package org.apache.ofbiz.content.data;

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
public class MetaDataPredicate implements Serializable {

	public static final long serialVersionUID = 927321078778286080L;
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

	public enum Fields {
		metaDataPredicateId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MetaDataPredicate(GenericValue value) {
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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