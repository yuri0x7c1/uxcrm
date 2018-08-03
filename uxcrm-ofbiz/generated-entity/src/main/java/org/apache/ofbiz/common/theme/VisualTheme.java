package org.apache.ofbiz.common.theme;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visual Theme
 */
public class VisualTheme implements Serializable {

	public static final long serialVersionUID = 4251403746616497152L;
	public static final String NAME = "VisualTheme";
	/**
	 * Visual Theme Id
	 */
	@Getter
	@Setter
	private String visualThemeId;
	/**
	 * Visual Theme Set Id
	 */
	@Getter
	@Setter
	private String visualThemeSetId;
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

	public enum Fields {
		visualThemeId, visualThemeSetId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public VisualTheme(GenericValue value) {
		visualThemeId = (String) value.get(Fields.visualThemeId.name());
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static VisualTheme fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualTheme(value);
	}

	public static List<VisualTheme> fromValues(List<GenericValue> values) {
		List<VisualTheme> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualTheme(value));
		}
		return entities;
	}
}