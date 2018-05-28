package org.apache.ofbiz.content.website;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Path Alias
 */
public class WebSitePathAlias implements Serializable {

	public static final long serialVersionUID = 5714235286894085120L;
	public static final String NAME = "WebSitePathAlias";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Path Alias
	 */
	@Getter
	@Setter
	private String pathAlias;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Alias To
	 */
	@Getter
	@Setter
	private String aliasTo;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;
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
		webSiteId, pathAlias, fromDate, thruDate, aliasTo, contentId, mapKey, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WebSitePathAlias(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		pathAlias = (String) value.get(Fields.pathAlias.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		aliasTo = (String) value.get(Fields.aliasTo.name());
		contentId = (String) value.get(Fields.contentId.name());
		mapKey = (String) value.get(Fields.mapKey.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WebSitePathAlias fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSitePathAlias(value);
	}

	public static List<WebSitePathAlias> fromValues(List<GenericValue> values) {
		List<WebSitePathAlias> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSitePathAlias(value));
		}
		return entities;
	}
}