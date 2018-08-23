package org.apache.ofbiz.common.portal;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portlet Category
 */
@FieldNameConstants
public class PortletCategory implements Serializable {

	public static final long serialVersionUID = 638472417627159552L;
	public static final String NAME = "PortletCategory";
	/**
	 * Portlet Category Id
	 */
	@Getter
	@Setter
	private String portletCategoryId;
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

	public PortletCategory(GenericValue value) {
		portletCategoryId = (String) value.get(FIELD_PORTLET_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PortletCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortletCategory(value);
	}

	public static List<PortletCategory> fromValues(List<GenericValue> values) {
		List<PortletCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortletCategory(value));
		}
		return entities;
	}
}