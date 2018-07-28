package org.apache.ofbiz.security.securitygroup;

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
public class TarpittedLoginView implements Serializable {

	public static final long serialVersionUID = 1098648000301551616L;
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

	public enum Fields {
		viewNameId, userLoginId, tarpitReleaseDateTime, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TarpittedLoginView(GenericValue value) {
		viewNameId = (String) value.get(Fields.viewNameId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		tarpitReleaseDateTime = (Long) value.get(Fields.tarpitReleaseDateTime
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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