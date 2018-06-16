package org.apache.ofbiz.product.category;

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
public class ProductCategoryLink implements Serializable {

	public static final long serialVersionUID = 8337481961051457536L;
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

	public enum Fields {
		productCategoryId, linkSeqId, fromDate, thruDate, comments, sequenceNum, titleText, detailText, imageUrl, imageTwoUrl, linkTypeEnumId, linkInfo, detailSubScreen, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryLink(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		linkSeqId = (String) value.get(Fields.linkSeqId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		titleText = (String) value.get(Fields.titleText.name());
		detailText = (String) value.get(Fields.detailText.name());
		imageUrl = (String) value.get(Fields.imageUrl.name());
		imageTwoUrl = (String) value.get(Fields.imageTwoUrl.name());
		linkTypeEnumId = (String) value.get(Fields.linkTypeEnumId.name());
		linkInfo = (String) value.get(Fields.linkInfo.name());
		detailSubScreen = (String) value.get(Fields.detailSubScreen.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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