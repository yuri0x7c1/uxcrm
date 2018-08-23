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
 * Web Site And Content
 */
@FieldNameConstants
public class WebSiteAndContent implements Serializable {

	public static final long serialVersionUID = 5958485896775596032L;
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

	public WebSiteAndContent(GenericValue value) {
		secureContentPrefix = (String) value.get(FIELD_SECURE_CONTENT_PREFIX);
		standardContentPrefix = (String) value
				.get(FIELD_STANDARD_CONTENT_PREFIX);
		httpPort = (String) value.get(FIELD_HTTP_PORT);
		siteName = (String) value.get(FIELD_SITE_NAME);
		httpsHost = (String) value.get(FIELD_HTTPS_HOST);
		httpsPort = (String) value.get(FIELD_HTTPS_PORT);
		allowProductStoreChange = (String) value
				.get(FIELD_ALLOW_PRODUCT_STORE_CHANGE);
		cookieDomain = (String) value.get(FIELD_COOKIE_DOMAIN);
		isDefault = (String) value.get(FIELD_IS_DEFAULT);
		displayMaintenancePage = (String) value
				.get(FIELD_DISPLAY_MAINTENANCE_PAGE);
		enableHttps = (String) value.get(FIELD_ENABLE_HTTPS);
		httpHost = (String) value.get(FIELD_HTTP_HOST);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		visualThemeSetId = (String) value.get(FIELD_VISUAL_THEME_SET_ID);
		hostedPathAlias = (String) value.get(FIELD_HOSTED_PATH_ALIAS);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		webSiteContentTypeId = (String) value
				.get(FIELD_WEB_SITE_CONTENT_TYPE_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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