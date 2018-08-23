package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class DataTemplateType implements Serializable {

	public static final long serialVersionUID = 1089654466668265472L;
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

	public DataTemplateType(GenericValue value) {
		dataTemplateTypeId = (String) value.get(FIELD_DATA_TEMPLATE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		extension = (String) value.get(FIELD_EXTENSION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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