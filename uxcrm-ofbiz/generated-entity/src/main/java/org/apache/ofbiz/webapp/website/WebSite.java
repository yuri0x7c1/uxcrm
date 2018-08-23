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
 * Web Site
 */
@FieldNameConstants
public class WebSite implements Serializable {

	public static final long serialVersionUID = 4065739714090171392L;
	public static final String NAME = "WebSite";
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
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Allow Product Store Change
	 */
	@Getter
	@Setter
	private String allowProductStoreChange;
	/**
	 * Hosted Path Alias
	 */
	@Getter
	@Setter
	private String hostedPathAlias;
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

	public WebSite(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		siteName = (String) value.get(FIELD_SITE_NAME);
		httpHost = (String) value.get(FIELD_HTTP_HOST);
		httpPort = (String) value.get(FIELD_HTTP_PORT);
		httpsHost = (String) value.get(FIELD_HTTPS_HOST);
		httpsPort = (String) value.get(FIELD_HTTPS_PORT);
		enableHttps = (String) value.get(FIELD_ENABLE_HTTPS);
		standardContentPrefix = (String) value
				.get(FIELD_STANDARD_CONTENT_PREFIX);
		secureContentPrefix = (String) value.get(FIELD_SECURE_CONTENT_PREFIX);
		cookieDomain = (String) value.get(FIELD_COOKIE_DOMAIN);
		visualThemeSetId = (String) value.get(FIELD_VISUAL_THEME_SET_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		allowProductStoreChange = (String) value
				.get(FIELD_ALLOW_PRODUCT_STORE_CHANGE);
		hostedPathAlias = (String) value.get(FIELD_HOSTED_PATH_ALIAS);
		isDefault = (String) value.get(FIELD_IS_DEFAULT);
		displayMaintenancePage = (String) value
				.get(FIELD_DISPLAY_MAINTENANCE_PAGE);
	}

	public static WebSite fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new WebSite(value);
	}

	public static List<WebSite> fromValues(List<GenericValue> values) {
		List<WebSite> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSite(value));
		}
		return entities;
	}
}