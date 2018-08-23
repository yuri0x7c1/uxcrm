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
 * Visual Theme Resource
 */
@FieldNameConstants
public class VisualThemeResource implements Serializable {

	public static final long serialVersionUID = 2179879722453681152L;
	public static final String NAME = "VisualThemeResource";
	/**
	 * Visual Theme Id
	 */
	@Getter
	@Setter
	private String visualThemeId;
	/**
	 * Resource Type Enum Id
	 */
	@Getter
	@Setter
	private String resourceTypeEnumId;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Resource Value
	 */
	@Getter
	@Setter
	private String resourceValue;
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

	public VisualThemeResource(GenericValue value) {
		visualThemeId = (String) value.get(FIELD_VISUAL_THEME_ID);
		resourceTypeEnumId = (String) value.get(FIELD_RESOURCE_TYPE_ENUM_ID);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		resourceValue = (String) value.get(FIELD_RESOURCE_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static VisualThemeResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualThemeResource(value);
	}

	public static List<VisualThemeResource> fromValues(List<GenericValue> values) {
		List<VisualThemeResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualThemeResource(value));
		}
		return entities;
	}
}