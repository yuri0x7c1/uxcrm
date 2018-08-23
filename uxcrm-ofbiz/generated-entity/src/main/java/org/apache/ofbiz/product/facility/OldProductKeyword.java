package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Product Keyword
 */
@FieldNameConstants
public class OldProductKeyword implements Serializable {

	public static final long serialVersionUID = 5380451700779085824L;
	public static final String NAME = "OldProductKeyword";
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
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
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

	public OldProductKeyword(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		keyword = (String) value.get(FIELD_KEYWORD);
		relevancyWeight = (Long) value.get(FIELD_RELEVANCY_WEIGHT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OldProductKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldProductKeyword(value);
	}

	public static List<OldProductKeyword> fromValues(List<GenericValue> values) {
		List<OldProductKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldProductKeyword(value));
		}
		return entities;
	}
}