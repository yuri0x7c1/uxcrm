package org.apache.ofbiz.product.cost;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component Attribute
 */
@FieldNameConstants
public class CostComponentAttribute implements Serializable {

	public static final long serialVersionUID = 6334649741976728576L;
	public static final String NAME = "CostComponentAttribute";
	/**
	 * Cost Component Id
	 */
	@Getter
	@Setter
	private String costComponentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public CostComponentAttribute(GenericValue value) {
		costComponentId = (String) value.get(FIELD_COST_COMPONENT_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CostComponentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentAttribute(value);
	}

	public static List<CostComponentAttribute> fromValues(
			List<GenericValue> values) {
		List<CostComponentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentAttribute(value));
		}
		return entities;
	}
}