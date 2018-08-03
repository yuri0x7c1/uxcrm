package org.apache.ofbiz.common.theme;

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
public class VisualThemeSet implements Serializable {

	public static final long serialVersionUID = 8900776436200285184L;
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

	public enum Fields {
		visualThemeSetId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public VisualThemeSet(GenericValue value) {
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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