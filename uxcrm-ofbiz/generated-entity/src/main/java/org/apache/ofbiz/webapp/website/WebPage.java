package org.apache.ofbiz.webapp.website;

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
public class WebPage implements Serializable {

	public static final long serialVersionUID = 7967115417887223808L;
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

	public enum Fields {
		webPageId, pageName, webSiteId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, contentId
	}

	public WebPage(GenericValue value) {
		webPageId = (String) value.get(Fields.webPageId.name());
		pageName = (String) value.get(Fields.pageName.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		contentId = (String) value.get(Fields.contentId.name());
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