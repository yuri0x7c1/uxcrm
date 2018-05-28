package org.apache.ofbiz.common.portal;

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
public class PortalPageColumn implements Serializable {

	public static final long serialVersionUID = 7908555635775116288L;
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

	public enum Fields {
		portalPageId, columnSeqId, columnWidthPixels, columnWidthPercentage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PortalPageColumn(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
		columnWidthPixels = (Long) value.get(Fields.columnWidthPixels.name());
		columnWidthPercentage = (Long) value.get(Fields.columnWidthPercentage
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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