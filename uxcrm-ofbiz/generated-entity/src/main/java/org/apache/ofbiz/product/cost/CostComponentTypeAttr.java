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
 * Cost Component Type Attr
 */
@FieldNameConstants
public class CostComponentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2594236337072617472L;
	public static final String NAME = "CostComponentTypeAttr";
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
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

	public CostComponentTypeAttr(GenericValue value) {
		costComponentTypeId = (String) value.get(FIELD_COST_COMPONENT_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CostComponentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentTypeAttr(value);
	}

	public static List<CostComponentTypeAttr> fromValues(
			List<GenericValue> values) {
		List<CostComponentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentTypeAttr(value));
		}
		return entities;
	}
}