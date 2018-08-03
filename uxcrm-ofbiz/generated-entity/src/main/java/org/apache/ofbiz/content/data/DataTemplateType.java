package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Template Type
 */
public class DataTemplateType implements Serializable {

	public static final long serialVersionUID = 7449289422158101504L;
	public static final String NAME = "DataTemplateType";
	/**
	 * Data Template Type Id
	 */
	@Getter
	@Setter
	private String dataTemplateTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
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
		dataTemplateTypeId, description, extension, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataTemplateType(GenericValue value) {
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		extension = (String) value.get(Fields.extension.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static DataTemplateType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataTemplateType(value);
	}

	public static List<DataTemplateType> fromValues(List<GenericValue> values) {
		List<DataTemplateType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataTemplateType(value));
		}
		return entities;
	}
}