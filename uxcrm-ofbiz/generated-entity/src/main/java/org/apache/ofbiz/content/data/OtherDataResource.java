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
 * Other Data Resource
 */
@FieldNameConstants
public class OtherDataResource implements Serializable {

	public static final long serialVersionUID = 3854908145134636032L;
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

	public OtherDataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		dataResourceContent = (byte[]) value.get(FIELD_DATA_RESOURCE_CONTENT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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