package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Iactn
 */
public class ProductFeatureIactn implements Serializable {

	public static final long serialVersionUID = 954677336686588928L;
	public static final String NAME = "ProductFeatureIactn";
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Id To
	 */
	@Getter
	@Setter
	private String productFeatureIdTo;
	/**
	 * Product Feature Iactn Type Id
	 */
	@Getter
	@Setter
	private String productFeatureIactnTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
		productFeatureId, productFeatureIdTo, productFeatureIactnTypeId, productId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureIactn(GenericValue value) {
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureIdTo = (String) value.get(Fields.productFeatureIdTo
				.name());
		productFeatureIactnTypeId = (String) value
				.get(Fields.productFeatureIactnTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeatureIactn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureIactn(value);
	}

	public static List<ProductFeatureIactn> fromValues(List<GenericValue> values) {
		List<ProductFeatureIactn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureIactn(value));
		}
		return entities;
	}
}