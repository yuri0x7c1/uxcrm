package org.apache.ofbiz.order.shoppinglist;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Item
 */
@FieldNameConstants
public class ShoppingListItem implements Serializable {

	public static final long serialVersionUID = 1795836746055795712L;
	public static final String NAME = "ShoppingListItem";
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Modified Price
	 */
	@Getter
	@Setter
	private BigDecimal modifiedPrice;
	/**
	 * Reserv Start
	 */
	@Getter
	@Setter
	private Timestamp reservStart;
	/**
	 * Reserv Length
	 */
	@Getter
	@Setter
	private BigDecimal reservLength;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Quantity Purchased
	 */
	@Getter
	@Setter
	private BigDecimal quantityPurchased;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
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

	public ShoppingListItem(GenericValue value) {
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		shoppingListItemSeqId = (String) value
				.get(FIELD_SHOPPING_LIST_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		modifiedPrice = (BigDecimal) value.get(FIELD_MODIFIED_PRICE);
		reservStart = (Timestamp) value.get(FIELD_RESERV_START);
		reservLength = (BigDecimal) value.get(FIELD_RESERV_LENGTH);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		quantityPurchased = (BigDecimal) value.get(FIELD_QUANTITY_PURCHASED);
		configId = (String) value.get(FIELD_CONFIG_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShoppingListItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShoppingListItem(value);
	}

	public static List<ShoppingListItem> fromValues(List<GenericValue> values) {
		List<ShoppingListItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShoppingListItem(value));
		}
		return entities;
	}
}