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
 * Portlet Portlet Category
 */
@FieldNameConstants
public class PortletPortletCategory implements Serializable {

	public static final long serialVersionUID = 3532901190788423680L;
	public static final String NAME = "PortletPortletCategory";
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Portlet Category Id
	 */
	@Getter
	@Setter
	private String portletCategoryId;
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

	public PortletPortletCategory(GenericValue value) {
		portalPortletId = (String) value.get(FIELD_PORTAL_PORTLET_ID);
		portletCategoryId = (String) value.get(FIELD_PORTLET_CATEGORY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PortletPortletCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortletPortletCategory(value);
	}

	public static List<PortletPortletCategory> fromValues(
			List<GenericValue> values) {
		List<PortletPortletCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortletPortletCategory(value));
		}
		return entities;
	}
}