package org.apache.ofbiz.security.securitygroup;

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
public class ProtectedView implements Serializable {

	public static final long serialVersionUID = 672486158562177024L;
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

	public enum Fields {
		groupId, viewNameId, maxHits, maxHitsDuration, tarpitDuration, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProtectedView(GenericValue value) {
		groupId = (String) value.get(Fields.groupId.name());
		viewNameId = (String) value.get(Fields.viewNameId.name());
		maxHits = (Long) value.get(Fields.maxHits.name());
		maxHitsDuration = (Long) value.get(Fields.maxHitsDuration.name());
		tarpitDuration = (Long) value.get(Fields.tarpitDuration.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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