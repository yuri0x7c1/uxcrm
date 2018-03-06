package org.apache.ofbiz.security.securitygroup.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tarpitted Login View
 */
public class TarpittedLoginView implements Serializable {

	public static final long serialVersionUID = 2488644684364335104L;
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

	public enum Fields {
		viewNameId, userLoginId, tarpitReleaseDateTime
	}

	public TarpittedLoginView(GenericValue value) {
		viewNameId = (String) value.get(Fields.viewNameId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		tarpitReleaseDateTime = (Long) value.get(Fields.tarpitReleaseDateTime
				.name());
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