package org.apache.ofbiz.content.data;

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
public class ElectronicText implements Serializable {

	public static final long serialVersionUID = 2772242056502483968L;
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

	public enum Fields {
		dataResourceId, textData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ElectronicText(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		textData = (String) value.get(Fields.textData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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