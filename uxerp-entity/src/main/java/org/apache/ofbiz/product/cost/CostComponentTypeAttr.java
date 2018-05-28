package org.apache.ofbiz.product.cost;

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
public class CostComponentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2021861822749284352L;
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

	public enum Fields {
		costComponentTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CostComponentTypeAttr(GenericValue value) {
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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