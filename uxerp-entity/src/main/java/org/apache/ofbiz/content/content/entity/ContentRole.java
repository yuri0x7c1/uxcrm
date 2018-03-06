package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Role
 */
public class ContentRole implements Serializable {

	public static final long serialVersionUID = 1426985381990248448L;
	public static final String NAME = "ContentRole";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		contentId, partyId, roleTypeId, fromDate, thruDate
	}

	public ContentRole(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ContentRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentRole(value);
	}

	public static List<ContentRole> fromValues(List<GenericValue> values) {
		List<ContentRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentRole(value));
		}
		return entities;
	}
}