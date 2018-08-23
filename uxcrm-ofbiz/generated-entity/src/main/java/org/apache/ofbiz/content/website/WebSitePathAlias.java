package org.apache.ofbiz.content.website;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WebSitePathAlias implements Serializable {

	public static final long serialVersionUID = 1084349909718497280L;
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

	public WebSitePathAlias(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		pathAlias = (String) value.get(FIELD_PATH_ALIAS);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		aliasTo = (String) value.get(FIELD_ALIAS_TO);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		mapKey = (String) value.get(FIELD_MAP_KEY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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