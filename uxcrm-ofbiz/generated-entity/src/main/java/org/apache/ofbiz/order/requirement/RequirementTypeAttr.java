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
 * Requirement Type Attr
 */
@FieldNameConstants
public class RequirementTypeAttr implements Serializable {

	public static final long serialVersionUID = 5693855450511251456L;
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

	public RequirementTypeAttr(GenericValue value) {
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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