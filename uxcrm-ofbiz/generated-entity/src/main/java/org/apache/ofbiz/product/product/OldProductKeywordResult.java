package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Product Keyword Result
 */
public class OldProductKeywordResult implements Serializable {

	public static final long serialVersionUID = 6690615199060207616L;
	public static final String NAME = "OldProductKeywordResult";
	/**
	 * Product Keyword Result Id
	 */
	@Getter
	@Setter
	private String productKeywordResultId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Search String
	 */
	@Getter
	@Setter
	private String searchString;
	/**
	 * Intra Keyword Operator
	 */
	@Getter
	@Setter
	private String intraKeywordOperator;
	/**
	 * Any Prefix
	 */
	@Getter
	@Setter
	private String anyPrefix;
	/**
	 * Any Suffix
	 */
	@Getter
	@Setter
	private String anySuffix;
	/**
	 * Remove Stems
	 */
	@Getter
	@Setter
	private String removeStems;
	/**
	 * Num Results
	 */
	@Getter
	@Setter
	private Long numResults;
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
		productKeywordResultId, visitId, productCategoryId, searchString, intraKeywordOperator, anyPrefix, anySuffix, removeStems, numResults, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldProductKeywordResult(GenericValue value) {
		productKeywordResultId = (String) value
				.get(Fields.productKeywordResultId.name());
		visitId = (String) value.get(Fields.visitId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		searchString = (String) value.get(Fields.searchString.name());
		intraKeywordOperator = (String) value.get(Fields.intraKeywordOperator
				.name());
		anyPrefix = (String) value.get(Fields.anyPrefix.name());
		anySuffix = (String) value.get(Fields.anySuffix.name());
		removeStems = (String) value.get(Fields.removeStems.name());
		numResults = (Long) value.get(Fields.numResults.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldProductKeywordResult fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldProductKeywordResult(value);
	}

	public static List<OldProductKeywordResult> fromValues(
			List<GenericValue> values) {
		List<OldProductKeywordResult> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldProductKeywordResult(value));
		}
		return entities;
	}
}