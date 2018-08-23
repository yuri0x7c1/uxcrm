package org.apache.ofbiz.order.requirement;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Desired Feature
 */
@FieldNameConstants
public class DesiredFeature implements Serializable {

	public static final long serialVersionUID = 1633960775272428544L;
	public static final String NAME = "DesiredFeature";
	/**
	 * Desired Feature Id
	 */
	@Getter
	@Setter
	private String desiredFeatureId;
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Optional Ind
	 */
	@Getter
	@Setter
	private String optionalInd;
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

	public DesiredFeature(GenericValue value) {
		desiredFeatureId = (String) value.get(FIELD_DESIRED_FEATURE_ID);
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		optionalInd = (String) value.get(FIELD_OPTIONAL_IND);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DesiredFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DesiredFeature(value);
	}

	public static List<DesiredFeature> fromValues(List<GenericValue> values) {
		List<DesiredFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DesiredFeature(value));
		}
		return entities;
	}
}