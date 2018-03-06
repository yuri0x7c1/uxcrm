package org.apache.ofbiz.content.website.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site And Content
 */
public class WebSiteAndContent implements Serializable {

	public static final long serialVersionUID = 1921220200504423424L;
	public static final String NAME = "WebSiteAndContent";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Site Name
	 */
	@Getter
	@Setter
	private String siteName;
	/**
	 * Http Host
	 */
	@Getter
	@Setter
	private String httpHost;
	/**
	 * Http Port
	 */
	@Getter
	@Setter
	private String httpPort;
	/**
	 * Https Host
	 */
	@Getter
	@Setter
	private String httpsHost;
	/**
	 * Https Port
	 */
	@Getter
	@Setter
	private String httpsPort;
	/**
	 * Enable Https
	 */
	@Getter
	@Setter
	private String enableHttps;
	/**
	 * Standard Content Prefix
	 */
	@Getter
	@Setter
	private String standardContentPrefix;
	/**
	 * Secure Content Prefix
	 */
	@Getter
	@Setter
	private String secureContentPrefix;
	/**
	 * Cookie Domain
	 */
	@Getter
	@Setter
	private String cookieDomain;
	/**
	 * Visual Theme Set Id
	 */
	@Getter
	@Setter
	private String visualThemeSetId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Web Site Content Type Id
	 */
	@Getter
	@Setter
	private String webSiteContentTypeId;
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

	public enum Fields {
		webSiteId, siteName, httpHost, httpPort, httpsHost, httpsPort, enableHttps, standardContentPrefix, secureContentPrefix, cookieDomain, visualThemeSetId, contentId, webSiteContentTypeId, fromDate, thruDate
	}

	public WebSiteAndContent(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		siteName = (String) value.get(Fields.siteName.name());
		httpHost = (String) value.get(Fields.httpHost.name());
		httpPort = (String) value.get(Fields.httpPort.name());
		httpsHost = (String) value.get(Fields.httpsHost.name());
		httpsPort = (String) value.get(Fields.httpsPort.name());
		enableHttps = (String) value.get(Fields.enableHttps.name());
		standardContentPrefix = (String) value.get(Fields.standardContentPrefix
				.name());
		secureContentPrefix = (String) value.get(Fields.secureContentPrefix
				.name());
		cookieDomain = (String) value.get(Fields.cookieDomain.name());
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		contentId = (String) value.get(Fields.contentId.name());
		webSiteContentTypeId = (String) value.get(Fields.webSiteContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WebSiteAndContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSiteAndContent(value);
	}

	public static List<WebSiteAndContent> fromValues(List<GenericValue> values) {
		List<WebSiteAndContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSiteAndContent(value));
		}
		return entities;
	}
}