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
 * Protected View
 */
@FieldNameConstants
public class ProtectedView implements Serializable {

	public static final long serialVersionUID = 8528515049609370624L;
	public static final String NAME = "ProtectedView";
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * View Name Id
	 */
	@Getter
	@Setter
	private String viewNameId;
	/**
	 * Max Hits
	 */
	@Getter
	@Setter
	private Long maxHits;
	/**
	 * Max Hits Duration
	 */
	@Getter
	@Setter
	private Long maxHitsDuration;
	/**
	 * Tarpit Duration
	 */
	@Getter
	@Setter
	private Long tarpitDuration;
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

	public ProtectedView(GenericValue value) {
		groupId = (String) value.get(FIELD_GROUP_ID);
		viewNameId = (String) value.get(FIELD_VIEW_NAME_ID);
		maxHits = (Long) value.get(FIELD_MAX_HITS);
		maxHitsDuration = (Long) value.get(FIELD_MAX_HITS_DURATION);
		tarpitDuration = (Long) value.get(FIELD_TARPIT_DURATION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProtectedView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProtectedView(value);
	}

	public static List<ProtectedView> fromValues(List<GenericValue> values) {
		List<ProtectedView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProtectedView(value));
		}
		return entities;
	}
}