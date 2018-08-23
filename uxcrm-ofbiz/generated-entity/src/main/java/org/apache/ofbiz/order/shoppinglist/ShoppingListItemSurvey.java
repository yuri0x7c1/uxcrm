package org.apache.ofbiz.order.shoppinglist;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShoppingListItemSurvey implements Serializable {

	public static final long serialVersionUID = 2897042019079764992L;
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

	public ShoppingListItemSurvey(GenericValue value) {
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		shoppingListItemSeqId = (String) value
				.get(FIELD_SHOPPING_LIST_ITEM_SEQ_ID);
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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