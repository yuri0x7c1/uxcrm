package org.apache.ofbiz.order.shoppinglist;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Item Survey
 */
public class ShoppingListItemSurvey implements Serializable {

	public static final long serialVersionUID = 1137997101004449792L;
	public static final String NAME = "ShoppingListItemSurvey";
	/**
	 * Shopping List Id
	 */
	@Getter
	@Setter
	private String shoppingListId;
	/**
	 * Shopping List Item Seq Id
	 */
	@Getter
	@Setter
	private String shoppingListItemSeqId;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
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
		shoppingListId, shoppingListItemSeqId, surveyResponseId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShoppingListItemSurvey(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		shoppingListItemSeqId = (String) value.get(Fields.shoppingListItemSeqId
				.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShoppingListItemSurvey fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShoppingListItemSurvey(value);
	}

	public static List<ShoppingListItemSurvey> fromValues(
			List<GenericValue> values) {
		List<ShoppingListItemSurvey> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShoppingListItemSurvey(value));
		}
		return entities;
	}
}