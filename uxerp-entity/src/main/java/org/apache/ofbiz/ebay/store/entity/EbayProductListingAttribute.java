package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Product Listing Attribute
 */
public class EbayProductListingAttribute implements Serializable {

	public static final long serialVersionUID = 6528751164168041472L;
	public static final String NAME = "EbayProductListingAttribute";
	/**
	 * Product Listing Id
	 */
	@Getter
	@Setter
	private String productListingId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;

	public enum Fields {
		productListingId, attrName, attrValue
	}

	public EbayProductListingAttribute(GenericValue value) {
		productListingId = (String) value.get(Fields.productListingId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
	}

	public static EbayProductListingAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayProductListingAttribute(value);
	}

	public static List<EbayProductListingAttribute> fromValues(
			List<GenericValue> values) {
		List<EbayProductListingAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayProductListingAttribute(value));
		}
		return entities;
	}
}