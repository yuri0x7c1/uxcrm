package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Link
 */
@FieldNameConstants
public class ProductCategoryLink implements Serializable {

	public static final long serialVersionUID = 4018836687889127424L;
	public static final String NAME = "ProductCategoryLink";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Link Seq Id
	 */
	@Getter
	@Setter
	private String linkSeqId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Title Text
	 */
	@Getter
	@Setter
	private String titleText;
	/**
	 * Detail Text
	 */
	@Getter
	@Setter
	private String detailText;
	/**
	 * Image Url
	 */
	@Getter
	@Setter
	private String imageUrl;
	/**
	 * Image Two Url
	 */
	@Getter
	@Setter
	private String imageTwoUrl;
	/**
	 * Link Type Enum Id
	 */
	@Getter
	@Setter
	private String linkTypeEnumId;
	/**
	 * Link Info
	 */
	@Getter
	@Setter
	private String linkInfo;
	/**
	 * Detail Sub Screen
	 */
	@Getter
	@Setter
	private String detailSubScreen;
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

	public ProductCategoryLink(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		linkSeqId = (String) value.get(FIELD_LINK_SEQ_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		titleText = (String) value.get(FIELD_TITLE_TEXT);
		detailText = (String) value.get(FIELD_DETAIL_TEXT);
		imageUrl = (String) value.get(FIELD_IMAGE_URL);
		imageTwoUrl = (String) value.get(FIELD_IMAGE_TWO_URL);
		linkTypeEnumId = (String) value.get(FIELD_LINK_TYPE_ENUM_ID);
		linkInfo = (String) value.get(FIELD_LINK_INFO);
		detailSubScreen = (String) value.get(FIELD_DETAIL_SUB_SCREEN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategoryLink fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryLink(value);
	}

	public static List<ProductCategoryLink> fromValues(List<GenericValue> values) {
		List<ProductCategoryLink> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryLink(value));
		}
		return entities;
	}
}