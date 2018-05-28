package org.apache.ofbiz.content.website;

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

	public static final long serialVersionUID = 3521989449713922048L;
	public static final String NAME = "WebSiteAndContent";
	/**
	 * Secure Content Prefix
	 */
	@Getter
	@Setter
	private String secureContentPrefix;
	/**
	 * Standard Content Prefix
	 */
	@Getter
	@Setter
	private String standardContentPrefix;
	/**
	 * Http Port
	 */
	@Getter
	@Setter
	private String httpPort;
	/**
	 * Site Name
	 */
	@Getter
	@Setter
	private String siteName;
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
	 * Allow Product Store Change
	 */
	@Getter
	@Setter
	private String allowProductStoreChange;
	/**
	 * Cookie Domain
	 */
	@Getter
	@Setter
	private String cookieDomain;
	/**
	 * Is Default
	 */
	@Getter
	@Setter
	private String isDefault;
	/**
	 * Webapp Path
	 */
	@Getter
	@Setter
	private String webappPath;
	/**
	 * Display Maintenance Page
	 */
	@Getter
	@Setter
	private String displayMaintenancePage;
	/**
	 * Enable Https
	 */
	@Getter
	@Setter
	private String enableHttps;
	/**
	 * Http Host
	 */
	@Getter
	@Setter
	private String httpHost;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Visual Theme Set Id
	 */
	@Getter
	@Setter
	private String visualThemeSetId;
	/**
	 * Hosted Path Alias
	 */
	@Getter
	@Setter
	private String hostedPathAlias;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Web Site Content Type Id
	 */
	@Getter
	@Setter
	private String webSiteContentTypeId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		secureContentPrefix, standardContentPrefix, httpPort, siteName, httpsHost, httpsPort, allowProductStoreChange, cookieDomain, isDefault, webappPath, displayMaintenancePage, enableHttps, httpHost, productStoreId, visualThemeSetId, hostedPathAlias, webSiteId, fromDate, webSiteContentTypeId, contentId, thruDate
	}

	public WebSiteAndContent(GenericValue value) {
		secureContentPrefix = (String) value.get(Fields.secureContentPrefix
				.name());
		standardContentPrefix = (String) value.get(Fields.standardContentPrefix
				.name());
		httpPort = (String) value.get(Fields.httpPort.name());
		siteName = (String) value.get(Fields.siteName.name());
		httpsHost = (String) value.get(Fields.httpsHost.name());
		httpsPort = (String) value.get(Fields.httpsPort.name());
		allowProductStoreChange = (String) value
				.get(Fields.allowProductStoreChange.name());
		cookieDomain = (String) value.get(Fields.cookieDomain.name());
		isDefault = (String) value.get(Fields.isDefault.name());
		webappPath = (String) value.get(Fields.webappPath.name());
		displayMaintenancePage = (String) value
				.get(Fields.displayMaintenancePage.name());
		enableHttps = (String) value.get(Fields.enableHttps.name());
		httpHost = (String) value.get(Fields.httpHost.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		hostedPathAlias = (String) value.get(Fields.hostedPathAlias.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		webSiteContentTypeId = (String) value.get(Fields.webSiteContentTypeId
				.name());
		contentId = (String) value.get(Fields.contentId.name());
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