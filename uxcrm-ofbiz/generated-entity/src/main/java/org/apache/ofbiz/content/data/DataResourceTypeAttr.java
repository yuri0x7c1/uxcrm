package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Type Attr
 */
public class DataResourceTypeAttr implements Serializable {

	public static final long serialVersionUID = 754988213851724800L;
	public static final String NAME = "DataResourceTypeAttr";
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
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
		dataResourceTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataResourceTypeAttr(GenericValue value) {
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
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

	public static DataResourceTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceTypeAttr(value);
	}

	public static List<DataResourceTypeAttr> fromValues(
			List<GenericValue> values) {
		List<DataResourceTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceTypeAttr(value));
		}
		return entities;
	}
}