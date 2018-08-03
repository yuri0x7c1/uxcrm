package org.apache.ofbiz.product.facility;

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
public class OldProductKeyword implements Serializable {

	public static final long serialVersionUID = 6490498582892846080L;
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

	public enum Fields {
		productId, keyword, relevancyWeight, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldProductKeyword(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		keyword = (String) value.get(Fields.keyword.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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