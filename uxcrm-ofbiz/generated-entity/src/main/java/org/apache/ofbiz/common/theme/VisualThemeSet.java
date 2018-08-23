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
 * Visual Theme Set
 */
@FieldNameConstants
public class VisualThemeSet implements Serializable {

	public static final long serialVersionUID = 5118237722672667648L;
	public static final String NAME = "VisualThemeSet";
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

	public VisualThemeSet(GenericValue value) {
		visualThemeSetId = (String) value.get(FIELD_VISUAL_THEME_SET_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static VisualThemeSet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualThemeSet(value);
	}

	public static List<VisualThemeSet> fromValues(List<GenericValue> values) {
		List<VisualThemeSet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualThemeSet(value));
		}
		return entities;
	}
}