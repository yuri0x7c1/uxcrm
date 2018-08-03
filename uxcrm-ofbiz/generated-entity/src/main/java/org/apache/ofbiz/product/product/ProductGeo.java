package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Geo
 */
public class ProductGeo implements Serializable {

	public static final long serialVersionUID = 3658841463186074624L;
	public static final String NAME = "ProductGeo";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Product Geo Enum Id
	 */
	@Getter
	@Setter
	private String productGeoEnumId;
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
		productId, geoId, productGeoEnumId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductGeo(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		geoId = (String) value.get(Fields.geoId.name());
		productGeoEnumId = (String) value.get(Fields.productGeoEnumId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductGeo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductGeo(value);
	}

	public static List<ProductGeo> fromValues(List<GenericValue> values) {
		List<ProductGeo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductGeo(value));
		}
		return entities;
	}
}