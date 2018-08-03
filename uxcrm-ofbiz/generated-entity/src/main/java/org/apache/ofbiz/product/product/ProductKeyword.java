package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Keyword
 */
public class ProductKeyword implements Serializable {

	public static final long serialVersionUID = 944217525901937664L;
	public static final String NAME = "ProductKeyword";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Keyword Type Id
	 */
	@Getter
	@Setter
	private String keywordTypeId;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
		productId, keyword, keywordTypeId, relevancyWeight, statusId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductKeyword(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		keyword = (String) value.get(Fields.keyword.name());
		keywordTypeId = (String) value.get(Fields.keywordTypeId.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
		statusId = (String) value.get(Fields.statusId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductKeyword(value);
	}

	public static List<ProductKeyword> fromValues(List<GenericValue> values) {
		List<ProductKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductKeyword(value));
		}
		return entities;
	}
}