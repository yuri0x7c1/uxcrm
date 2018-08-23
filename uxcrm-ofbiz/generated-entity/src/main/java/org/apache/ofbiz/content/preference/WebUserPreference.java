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
 * Web User Preference
 */
@FieldNameConstants
public class WebUserPreference implements Serializable {

	public static final long serialVersionUID = 1512919067180101632L;
	public static final String NAME = "WebUserPreference";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Web Preference Type Id
	 */
	@Getter
	@Setter
	private String webPreferenceTypeId;
	/**
	 * Web Preference Value
	 */
	@Getter
	@Setter
	private String webPreferenceValue;
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

	public WebUserPreference(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		webPreferenceTypeId = (String) value.get(FIELD_WEB_PREFERENCE_TYPE_ID);
		webPreferenceValue = (String) value.get(FIELD_WEB_PREFERENCE_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WebUserPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebUserPreference(value);
	}

	public static List<WebUserPreference> fromValues(List<GenericValue> values) {
		List<WebUserPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebUserPreference(value));
		}
		return entities;
	}
}