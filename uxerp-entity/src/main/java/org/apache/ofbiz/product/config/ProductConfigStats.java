package org.apache.ofbiz.product.config;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Stats
 */
public class ProductConfigStats implements Serializable {

	public static final long serialVersionUID = 8483664181412344832L;
	public static final String NAME = "ProductConfigStats";
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Num Of Confs
	 */
	@Getter
	@Setter
	private Long numOfConfs;
	/**
	 * Config Type Id
	 */
	@Getter
	@Setter
	private String configTypeId;
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
		configId, productId, numOfConfs, configTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductConfigStats(GenericValue value) {
		configId = (String) value.get(Fields.configId.name());
		productId = (String) value.get(Fields.productId.name());
		numOfConfs = (Long) value.get(Fields.numOfConfs.name());
		configTypeId = (String) value.get(Fields.configTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductConfigStats fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigStats(value);
	}

	public static List<ProductConfigStats> fromValues(List<GenericValue> values) {
		List<ProductConfigStats> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigStats(value));
		}
		return entities;
	}
}