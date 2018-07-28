package org.apache.ofbiz.order.requirement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Type Attr
 */
public class RequirementTypeAttr implements Serializable {

	public static final long serialVersionUID = 8784656026116508672L;
	public static final String NAME = "RequirementTypeAttr";
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
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
		requirementTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RequirementTypeAttr(GenericValue value) {
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static RequirementTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementTypeAttr(value);
	}

	public static List<RequirementTypeAttr> fromValues(List<GenericValue> values) {
		List<RequirementTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementTypeAttr(value));
		}
		return entities;
	}
}