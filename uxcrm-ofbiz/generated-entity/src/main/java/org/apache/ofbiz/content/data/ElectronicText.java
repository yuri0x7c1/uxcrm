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
 * Electronic Text
 */
@FieldNameConstants
public class ElectronicText implements Serializable {

	public static final long serialVersionUID = 1936140087979920384L;
	public static final String NAME = "ElectronicText";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Text Data
	 */
	@Getter
	@Setter
	private String textData;
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

	public ElectronicText(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		textData = (String) value.get(FIELD_TEXT_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ElectronicText fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ElectronicText(value);
	}

	public static List<ElectronicText> fromValues(List<GenericValue> values) {
		List<ElectronicText> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ElectronicText(value));
		}
		return entities;
	}
}