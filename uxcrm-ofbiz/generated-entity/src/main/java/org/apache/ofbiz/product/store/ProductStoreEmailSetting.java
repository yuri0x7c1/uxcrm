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
 * Product Store Email Setting
 */
@FieldNameConstants
public class ProductStoreEmailSetting implements Serializable {

	public static final long serialVersionUID = 3863148866646727680L;
	public static final String NAME = "ProductStoreEmailSetting";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Email Type
	 */
	@Getter
	@Setter
	private String emailType;
	/**
	 * Body Screen Location
	 */
	@Getter
	@Setter
	private String bodyScreenLocation;
	/**
	 * Xslfo Attach Screen Location
	 */
	@Getter
	@Setter
	private String xslfoAttachScreenLocation;
	/**
	 * From Address
	 */
	@Getter
	@Setter
	private String fromAddress;
	/**
	 * Cc Address
	 */
	@Getter
	@Setter
	private String ccAddress;
	/**
	 * Bcc Address
	 */
	@Getter
	@Setter
	private String bccAddress;
	/**
	 * Subject
	 */
	@Getter
	@Setter
	private String subject;
	/**
	 * Content Type
	 */
	@Getter
	@Setter
	private String contentType;
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

	public ProductStoreEmailSetting(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		emailType = (String) value.get(FIELD_EMAIL_TYPE);
		bodyScreenLocation = (String) value.get(FIELD_BODY_SCREEN_LOCATION);
		xslfoAttachScreenLocation = (String) value
				.get(FIELD_XSLFO_ATTACH_SCREEN_LOCATION);
		fromAddress = (String) value.get(FIELD_FROM_ADDRESS);
		ccAddress = (String) value.get(FIELD_CC_ADDRESS);
		bccAddress = (String) value.get(FIELD_BCC_ADDRESS);
		subject = (String) value.get(FIELD_SUBJECT);
		contentType = (String) value.get(FIELD_CONTENT_TYPE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductStoreEmailSetting fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreEmailSetting(value);
	}

	public static List<ProductStoreEmailSetting> fromValues(
			List<GenericValue> values) {
		List<ProductStoreEmailSetting> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreEmailSetting(value));
		}
		return entities;
	}
}