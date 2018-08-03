package org.apache.ofbiz.order.shoppinglist;

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
public class ShoppingListItem implements Serializable {

	public static final long serialVersionUID = 3557806714907648L;
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

	public enum Fields {
		shoppingListId, shoppingListItemSeqId, productId, quantity, modifiedPrice, reservStart, reservLength, reservPersons, quantityPurchased, configId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShoppingListItem(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		shoppingListItemSeqId = (String) value.get(Fields.shoppingListItemSeqId
				.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		modifiedPrice = (BigDecimal) value.get(Fields.modifiedPrice.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		quantityPurchased = (BigDecimal) value.get(Fields.quantityPurchased
				.name());
		configId = (String) value.get(Fields.configId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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