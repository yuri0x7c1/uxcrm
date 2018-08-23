package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Rating Type
 */
@FieldNameConstants
public class PerfRatingType implements Serializable {

	public static final long serialVersionUID = 7602992789324417024L;
	public static final String NAME = "PerfRatingType";
	/**
	 * Perf Rating Type Id
	 */
	@Getter
	@Setter
	private String perfRatingTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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

	public PerfRatingType(GenericValue value) {
		perfRatingTypeId = (String) value.get(FIELD_PERF_RATING_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PerfRatingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfRatingType(value);
	}

	public static List<PerfRatingType> fromValues(List<GenericValue> values) {
		List<PerfRatingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfRatingType(value));
		}
		return entities;
	}
}