package org.apache.ofbiz.common.portal;

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
public class PortalPagePortlet implements Serializable {

	public static final long serialVersionUID = 3006924775222020096L;
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

	public enum Fields {
		portalPageId, portalPortletId, portletSeqId, columnSeqId, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PortalPagePortlet(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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