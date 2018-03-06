package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Option Iactn
 */
public class ProductConfigOptionIactn implements Serializable {

	public static final long serialVersionUID = 8344028786583824384L;
	public static final String NAME = "ProductConfigOptionIactn";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Config Option Id
	 */
	@Getter
	@Setter
	private String configOptionId;
	/**
	 * Config Item Id To
	 */
	@Getter
	@Setter
	private String configItemIdTo;
	/**
	 * Config Option Id To
	 */
	@Getter
	@Setter
	private String configOptionIdTo;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Config Iactn Type Id
	 */
	@Getter
	@Setter
	private String configIactnTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		configItemId, configOptionId, configItemIdTo, configOptionIdTo, sequenceNum, configIactnTypeId, description
	}

	public ProductConfigOptionIactn(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		configItemIdTo = (String) value.get(Fields.configItemIdTo.name());
		configOptionIdTo = (String) value.get(Fields.configOptionIdTo.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		configIactnTypeId = (String) value.get(Fields.configIactnTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductConfigOptionIactn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigOptionIactn(value);
	}

	public static List<ProductConfigOptionIactn> fromValues(
			List<GenericValue> values) {
		List<ProductConfigOptionIactn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigOptionIactn(value));
		}
		return entities;
	}
}