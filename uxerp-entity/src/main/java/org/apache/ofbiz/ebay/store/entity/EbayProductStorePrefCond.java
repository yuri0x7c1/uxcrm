package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Product Store Pref Cond
 */
public class EbayProductStorePrefCond implements Serializable {

	public static final long serialVersionUID = 825422432023010304L;
	public static final String NAME = "EbayProductStorePrefCond";
	/**
	 * Pref Cond Id
	 */
	@Getter
	@Setter
	private String prefCondId;
	/**
	 * Acceptance Condition
	 */
	@Getter
	@Setter
	private String acceptanceCondition;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Parent Pref Cond Id
	 */
	@Getter
	@Setter
	private String parentPrefCondId;

	public enum Fields {
		prefCondId, acceptanceCondition, description, parentPrefCondId
	}

	public EbayProductStorePrefCond(GenericValue value) {
		prefCondId = (String) value.get(Fields.prefCondId.name());
		acceptanceCondition = (String) value.get(Fields.acceptanceCondition
				.name());
		description = (String) value.get(Fields.description.name());
		parentPrefCondId = (String) value.get(Fields.parentPrefCondId.name());
	}

	public static EbayProductStorePrefCond fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayProductStorePrefCond(value);
	}

	public static List<EbayProductStorePrefCond> fromValues(
			List<GenericValue> values) {
		List<EbayProductStorePrefCond> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayProductStorePrefCond(value));
		}
		return entities;
	}
}