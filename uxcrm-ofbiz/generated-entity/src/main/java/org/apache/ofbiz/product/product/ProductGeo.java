package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductGeo implements Serializable {

	public static final long serialVersionUID = 4636936655671498752L;
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

	public ProductGeo(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		productGeoEnumId = (String) value.get(FIELD_PRODUCT_GEO_ENUM_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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