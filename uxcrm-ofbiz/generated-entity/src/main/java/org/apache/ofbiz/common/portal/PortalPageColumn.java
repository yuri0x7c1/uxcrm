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
 * Portal Page Column
 */
@FieldNameConstants
public class PortalPageColumn implements Serializable {

	public static final long serialVersionUID = 3864845441301041152L;
	public static final String NAME = "PortalPageColumn";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;
	/**
	 * Column Width Pixels
	 */
	@Getter
	@Setter
	private Long columnWidthPixels;
	/**
	 * Column Width Percentage
	 */
	@Getter
	@Setter
	private Long columnWidthPercentage;
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

	public PortalPageColumn(GenericValue value) {
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		columnSeqId = (String) value.get(FIELD_COLUMN_SEQ_ID);
		columnWidthPixels = (Long) value.get(FIELD_COLUMN_WIDTH_PIXELS);
		columnWidthPercentage = (Long) value.get(FIELD_COLUMN_WIDTH_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PortalPageColumn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPageColumn(value);
	}

	public static List<PortalPageColumn> fromValues(List<GenericValue> values) {
		List<PortalPageColumn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPageColumn(value));
		}
		return entities;
	}
}