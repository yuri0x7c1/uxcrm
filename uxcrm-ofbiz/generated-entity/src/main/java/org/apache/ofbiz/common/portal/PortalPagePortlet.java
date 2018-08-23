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
 * Portal Page Portlet
 */
@FieldNameConstants
public class PortalPagePortlet implements Serializable {

	public static final long serialVersionUID = 2123987395184161792L;
	public static final String NAME = "PortalPagePortlet";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public PortalPagePortlet(GenericValue value) {
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		portalPortletId = (String) value.get(FIELD_PORTAL_PORTLET_ID);
		portletSeqId = (String) value.get(FIELD_PORTLET_SEQ_ID);
		columnSeqId = (String) value.get(FIELD_COLUMN_SEQ_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PortalPagePortlet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPagePortlet(value);
	}

	public static List<PortalPagePortlet> fromValues(List<GenericValue> values) {
		List<PortalPagePortlet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPagePortlet(value));
		}
		return entities;
	}
}