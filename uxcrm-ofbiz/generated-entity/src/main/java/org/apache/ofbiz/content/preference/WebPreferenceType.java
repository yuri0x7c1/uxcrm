package org.apache.ofbiz.content.preference;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Preference Type
 */
@FieldNameConstants
public class WebPreferenceType implements Serializable {

	public static final long serialVersionUID = 1999168848970871808L;
	public static final String NAME = "WebPreferenceType";
	/**
	 * Web Preference Type Id
	 */
	@Getter
	@Setter
	private String webPreferenceTypeId;
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

	public WebPreferenceType(GenericValue value) {
		webPreferenceTypeId = (String) value.get(FIELD_WEB_PREFERENCE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WebPreferenceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebPreferenceType(value);
	}

	public static List<WebPreferenceType> fromValues(List<GenericValue> values) {
		List<WebPreferenceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebPreferenceType(value));
		}
		return entities;
	}
}