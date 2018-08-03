package org.apache.ofbiz.product.config;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Option Iactn
 */
public class ProductConfigOptionIactn implements Serializable {

	public static final long serialVersionUID = 7658322806520136704L;
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

	public enum Fields {
		configItemId, configOptionId, configItemIdTo, configOptionIdTo, sequenceNum, configIactnTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductConfigOptionIactn(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		configItemIdTo = (String) value.get(Fields.configItemIdTo.name());
		configOptionIdTo = (String) value.get(Fields.configOptionIdTo.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		configIactnTypeId = (String) value.get(Fields.configIactnTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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