package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Other Data Resource
 */
public class OtherDataResource implements Serializable {

	public static final long serialVersionUID = 7183756716654854144L;
	public static final String NAME = "OtherDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Data Resource Content
	 */
	@Getter
	@Setter
	private byte[] dataResourceContent;
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
		dataResourceId, dataResourceContent, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OtherDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		dataResourceContent = (byte[]) value.get(Fields.dataResourceContent
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OtherDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OtherDataResource(value);
	}

	public static List<OtherDataResource> fromValues(List<GenericValue> values) {
		List<OtherDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OtherDataResource(value));
		}
		return entities;
	}
}