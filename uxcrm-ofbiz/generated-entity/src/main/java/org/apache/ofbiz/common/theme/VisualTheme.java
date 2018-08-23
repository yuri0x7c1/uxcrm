package org.apache.ofbiz.common.theme;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class VisualTheme implements Serializable {

	public static final long serialVersionUID = 4099383446523424768L;
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

	public VisualTheme(GenericValue value) {
		visualThemeId = (String) value.get(FIELD_VISUAL_THEME_ID);
		visualThemeSetId = (String) value.get(FIELD_VISUAL_THEME_SET_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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