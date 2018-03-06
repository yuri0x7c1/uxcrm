package org.apache.ofbiz.ebay.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Config
 */
public class EbayConfig implements Serializable {

	public static final long serialVersionUID = 4494193864683018240L;
	public static final String NAME = "EbayConfig";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Dev Id
	 */
	@Getter
	@Setter
	private String devId;
	/**
	 * App Id
	 */
	@Getter
	@Setter
	private String appId;
	/**
	 * Cert Id
	 */
	@Getter
	@Setter
	private String certId;
	/**
	 * Token
	 */
	@Getter
	@Setter
	private String token;
	/**
	 * Compatibility Level
	 */
	@Getter
	@Setter
	private String compatibilityLevel;
	/**
	 * Site Id
	 */
	@Getter
	@Setter
	private String siteId;
	/**
	 * Xml Gateway Uri
	 */
	@Getter
	@Setter
	private String xmlGatewayUri;
	/**
	 * Custom Xml
	 */
	@Getter
	@Setter
	private String customXml;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;

	public enum Fields {
		productStoreId, devId, appId, certId, token, compatibilityLevel, siteId, xmlGatewayUri, customXml, webSiteId
	}

	public EbayConfig(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		devId = (String) value.get(Fields.devId.name());
		appId = (String) value.get(Fields.appId.name());
		certId = (String) value.get(Fields.certId.name());
		token = (String) value.get(Fields.token.name());
		compatibilityLevel = (String) value.get(Fields.compatibilityLevel
				.name());
		siteId = (String) value.get(Fields.siteId.name());
		xmlGatewayUri = (String) value.get(Fields.xmlGatewayUri.name());
		customXml = (String) value.get(Fields.customXml.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
	}

	public static EbayConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayConfig(value);
	}

	public static List<EbayConfig> fromValues(List<GenericValue> values) {
		List<EbayConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayConfig(value));
		}
		return entities;
	}
}