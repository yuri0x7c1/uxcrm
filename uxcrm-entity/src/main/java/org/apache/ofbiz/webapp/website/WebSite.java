package org.apache.ofbiz.webapp.website;

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
public class WebSite implements Serializable {

	public static final long serialVersionUID = 46404418741415936L;
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
	 * Webapp Path
	 */
	@Getter
	@Setter
	private String webappPath;
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

	public enum Fields {
		webSiteId, siteName, httpHost, httpPort, httpsHost, httpsPort, enableHttps, webappPath, standardContentPrefix, secureContentPrefix, cookieDomain, visualThemeSetId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, productStoreId, allowProductStoreChange, hostedPathAlias, isDefault, displayMaintenancePage
	}

	public WebSite(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		siteName = (String) value.get(Fields.siteName.name());
		httpHost = (String) value.get(Fields.httpHost.name());
		httpPort = (String) value.get(Fields.httpPort.name());
		httpsHost = (String) value.get(Fields.httpsHost.name());
		httpsPort = (String) value.get(Fields.httpsPort.name());
		enableHttps = (String) value.get(Fields.enableHttps.name());
		webappPath = (String) value.get(Fields.webappPath.name());
		standardContentPrefix = (String) value.get(Fields.standardContentPrefix
				.name());
		secureContentPrefix = (String) value.get(Fields.secureContentPrefix
				.name());
		cookieDomain = (String) value.get(Fields.cookieDomain.name());
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		allowProductStoreChange = (String) value
				.get(Fields.allowProductStoreChange.name());
		hostedPathAlias = (String) value.get(Fields.hostedPathAlias.name());
		isDefault = (String) value.get(Fields.isDefault.name());
		displayMaintenancePage = (String) value
				.get(Fields.displayMaintenancePage.name());
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