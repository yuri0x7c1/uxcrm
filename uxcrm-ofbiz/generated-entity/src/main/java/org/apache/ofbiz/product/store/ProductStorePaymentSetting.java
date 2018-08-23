package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductStorePaymentSetting implements Serializable {

	public static final long serialVersionUID = 8102663574331029504L;
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

	public ProductStorePaymentSetting(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		paymentServiceTypeEnumId = (String) value
				.get(FIELD_PAYMENT_SERVICE_TYPE_ENUM_ID);
		paymentService = (String) value.get(FIELD_PAYMENT_SERVICE);
		paymentCustomMethodId = (String) value
				.get(FIELD_PAYMENT_CUSTOM_METHOD_ID);
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		paymentPropertiesPath = (String) value
				.get(FIELD_PAYMENT_PROPERTIES_PATH);
		applyToAllProducts = (String) value.get(FIELD_APPLY_TO_ALL_PRODUCTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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