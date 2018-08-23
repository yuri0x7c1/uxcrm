package org.apache.ofbiz.product.config;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Conf Item Content
 */
@FieldNameConstants
public class ProdConfItemContent implements Serializable {

	public static final long serialVersionUID = 4951870848049887232L;
	public static final String NAME = "ProdConfItemContent";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Conf Item Content Type Id
	 */
	@Getter
	@Setter
	private String confItemContentTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public ProdConfItemContent(GenericValue value) {
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		confItemContentTypeId = (String) value
				.get(FIELD_CONF_ITEM_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProdConfItemContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdConfItemContent(value);
	}

	public static List<ProdConfItemContent> fromValues(List<GenericValue> values) {
		List<ProdConfItemContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdConfItemContent(value));
		}
		return entities;
	}
}