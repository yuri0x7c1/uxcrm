package org.apache.ofbiz.webapp.website;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Page
 */
@FieldNameConstants
public class WebPage implements Serializable {

	public static final long serialVersionUID = 4601365251141622784L;
	public static final String NAME = "WebPage";
	/**
	 * Web Page Id
	 */
	@Getter
	@Setter
	private String webPageId;
	/**
	 * Page Name
	 */
	@Getter
	@Setter
	private String pageName;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
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
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;

	public WebPage(GenericValue value) {
		webPageId = (String) value.get(FIELD_WEB_PAGE_ID);
		pageName = (String) value.get(FIELD_PAGE_NAME);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		contentId = (String) value.get(FIELD_CONTENT_ID);
	}

	public static WebPage fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new WebPage(value);
	}

	public static List<WebPage> fromValues(List<GenericValue> values) {
		List<WebPage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebPage(value));
		}
		return entities;
	}
}