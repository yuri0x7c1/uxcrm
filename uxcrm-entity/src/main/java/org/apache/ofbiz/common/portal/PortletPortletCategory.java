package org.apache.ofbiz.common.portal;

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
public class PortletPortletCategory implements Serializable {

	public static final long serialVersionUID = 7301607364010921984L;
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

	public enum Fields {
		portalPortletId, portletCategoryId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PortletPortletCategory(GenericValue value) {
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletCategoryId = (String) value.get(Fields.portletCategoryId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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