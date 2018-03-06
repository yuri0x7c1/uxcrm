package org.apache.ofbiz.webapp.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site
 */
public class WebSite implements Serializable {

	public static final long serialVersionUID = 5984217362428736512L;
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

	public enum Fields {
		webSiteId, siteName, httpHost, httpPort, httpsHost, httpsPort, enableHttps, standardContentPrefix, secureContentPrefix, cookieDomain, visualThemeSetId
	}

	public WebSite(GenericValue value) {
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