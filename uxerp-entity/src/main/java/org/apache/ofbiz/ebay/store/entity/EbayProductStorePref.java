package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Product Store Pref
 */
public class EbayProductStorePref implements Serializable {

	public static final long serialVersionUID = 99234357382212608L;
	public static final String NAME = "EbayProductStorePref";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Auto Pref Enum Id
	 */
	@Getter
	@Setter
	private String autoPrefEnumId;
	/**
	 * Auto Pref Job Id
	 */
	@Getter
	@Setter
	private String autoPrefJobId;
	/**
	 * Enabled
	 */
	@Getter
	@Setter
	private String enabled;
	/**
	 * Condition 1
	 */
	@Getter
	@Setter
	private String condition1;
	/**
	 * Condition 2
	 */
	@Getter
	@Setter
	private String condition2;
	/**
	 * Condition 3
	 */
	@Getter
	@Setter
	private String condition3;
	/**
	 * Parent Pref Cond Id
	 */
	@Getter
	@Setter
	private String parentPrefCondId;

	public enum Fields {
		productStoreId, autoPrefEnumId, autoPrefJobId, enabled, condition1, condition2, condition3, parentPrefCondId
	}

	public EbayProductStorePref(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		autoPrefEnumId = (String) value.get(Fields.autoPrefEnumId.name());
		autoPrefJobId = (String) value.get(Fields.autoPrefJobId.name());
		enabled = (String) value.get(Fields.enabled.name());
		condition1 = (String) value.get(Fields.condition1.name());
		condition2 = (String) value.get(Fields.condition2.name());
		condition3 = (String) value.get(Fields.condition3.name());
		parentPrefCondId = (String) value.get(Fields.parentPrefCondId.name());
	}

	public static EbayProductStorePref fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayProductStorePref(value);
	}

	public static List<EbayProductStorePref> fromValues(
			List<GenericValue> values) {
		List<EbayProductStorePref> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayProductStorePref(value));
		}
		return entities;
	}
}