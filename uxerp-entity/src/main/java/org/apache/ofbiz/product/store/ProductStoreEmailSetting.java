package org.apache.ofbiz.product.store;

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
public class ProductStoreEmailSetting implements Serializable {

	public static final long serialVersionUID = 6377764793514115072L;
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

	public enum Fields {
		productStoreId, emailType, bodyScreenLocation, xslfoAttachScreenLocation, fromAddress, ccAddress, bccAddress, subject, contentType, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreEmailSetting(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		emailType = (String) value.get(Fields.emailType.name());
		bodyScreenLocation = (String) value.get(Fields.bodyScreenLocation
				.name());
		xslfoAttachScreenLocation = (String) value
				.get(Fields.xslfoAttachScreenLocation.name());
		fromAddress = (String) value.get(Fields.fromAddress.name());
		ccAddress = (String) value.get(Fields.ccAddress.name());
		bccAddress = (String) value.get(Fields.bccAddress.name());
		subject = (String) value.get(Fields.subject.name());
		contentType = (String) value.get(Fields.contentType.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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