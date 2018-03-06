package org.apache.ofbiz.security.securitygroup.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Protected View
 */
public class ProtectedView implements Serializable {

	public static final long serialVersionUID = 1413452080968269824L;
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

	public enum Fields {
		groupId, viewNameId, maxHits, maxHitsDuration, tarpitDuration
	}

	public ProtectedView(GenericValue value) {
		groupId = (String) value.get(Fields.groupId.name());
		viewNameId = (String) value.get(Fields.viewNameId.name());
		maxHits = (Long) value.get(Fields.maxHits.name());
		maxHitsDuration = (Long) value.get(Fields.maxHitsDuration.name());
		tarpitDuration = (Long) value.get(Fields.tarpitDuration.name());
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