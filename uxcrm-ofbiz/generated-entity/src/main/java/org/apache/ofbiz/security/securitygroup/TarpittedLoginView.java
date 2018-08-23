package org.apache.ofbiz.security.securitygroup;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tarpitted Login View
 */
@FieldNameConstants
public class TarpittedLoginView implements Serializable {

	public static final long serialVersionUID = 1201574893833940992L;
	public static final String NAME = "TarpittedLoginView";
	/**
	 * View Name Id
	 */
	@Getter
	@Setter
	private String viewNameId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Tarpit Release Date Time
	 */
	@Getter
	@Setter
	private Long tarpitReleaseDateTime;
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

	public TarpittedLoginView(GenericValue value) {
		viewNameId = (String) value.get(FIELD_VIEW_NAME_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		tarpitReleaseDateTime = (Long) value
				.get(FIELD_TARPIT_RELEASE_DATE_TIME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TarpittedLoginView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TarpittedLoginView(value);
	}

	public static List<TarpittedLoginView> fromValues(List<GenericValue> values) {
		List<TarpittedLoginView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TarpittedLoginView(value));
		}
		return entities;
	}
}