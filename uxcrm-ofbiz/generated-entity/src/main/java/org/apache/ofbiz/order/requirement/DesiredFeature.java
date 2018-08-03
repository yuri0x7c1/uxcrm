package org.apache.ofbiz.order.requirement;

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
public class DesiredFeature implements Serializable {

	public static final long serialVersionUID = 661778416724460544L;
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

	public enum Fields {
		desiredFeatureId, requirementId, productFeatureId, optionalInd, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DesiredFeature(GenericValue value) {
		desiredFeatureId = (String) value.get(Fields.desiredFeatureId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		optionalInd = (String) value.get(Fields.optionalInd.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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