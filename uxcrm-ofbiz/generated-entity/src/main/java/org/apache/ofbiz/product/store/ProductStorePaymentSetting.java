package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Payment Setting
 */
public class ProductStorePaymentSetting implements Serializable {

	public static final long serialVersionUID = 8412827228205787136L;
	public static final String NAME = "ProductStorePaymentSetting";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Payment Service Type Enum Id
	 */
	@Getter
	@Setter
	private String paymentServiceTypeEnumId;
	/**
	 * Payment Service
	 */
	@Getter
	@Setter
	private String paymentService;
	/**
	 * Payment Custom Method Id
	 */
	@Getter
	@Setter
	private String paymentCustomMethodId;
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Payment Properties Path
	 */
	@Getter
	@Setter
	private String paymentPropertiesPath;
	/**
	 * Apply To All Products
	 */
	@Getter
	@Setter
	private String applyToAllProducts;
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
		productStoreId, paymentMethodTypeId, paymentServiceTypeEnumId, paymentService, paymentCustomMethodId, paymentGatewayConfigId, paymentPropertiesPath, applyToAllProducts, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStorePaymentSetting(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentServiceTypeEnumId = (String) value
				.get(Fields.paymentServiceTypeEnumId.name());
		paymentService = (String) value.get(Fields.paymentService.name());
		paymentCustomMethodId = (String) value.get(Fields.paymentCustomMethodId
				.name());
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		paymentPropertiesPath = (String) value.get(Fields.paymentPropertiesPath
				.name());
		applyToAllProducts = (String) value.get(Fields.applyToAllProducts
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStorePaymentSetting fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStorePaymentSetting(value);
	}

	public static List<ProductStorePaymentSetting> fromValues(
			List<GenericValue> values) {
		List<ProductStorePaymentSetting> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStorePaymentSetting(value));
		}
		return entities;
	}
}