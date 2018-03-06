package org.apache.ofbiz.order.shoppinglist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Item Survey
 */
public class ShoppingListItemSurvey implements Serializable {

	public static final long serialVersionUID = 9052434114302068736L;
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

	public enum Fields {
		shoppingListId, shoppingListItemSeqId, surveyResponseId
	}

	public ShoppingListItemSurvey(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		shoppingListItemSeqId = (String) value.get(Fields.shoppingListItemSeqId
				.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
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