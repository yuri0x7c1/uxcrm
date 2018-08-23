package org.apache.ofbiz.order.shoppingcart;

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
 * Cart Abandoned Line
 */
@FieldNameConstants
public class CartAbandonedLine implements Serializable {

	public static final long serialVersionUID = 6839517541647413248L;
	public static final String NAME = "CartAbandonedLine";
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Cart Abandoned Line Seq Id
	 */
	@Getter
	@Setter
	private String cartAbandonedLineSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Total With Adjustments
	 */
	@Getter
	@Setter
	private BigDecimal totalWithAdjustments;
	/**
	 * Was Reserved
	 */
	@Getter
	@Setter
	private String wasReserved;
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

	public CartAbandonedLine(GenericValue value) {
		visitId = (String) value.get(FIELD_VISIT_ID);
		cartAbandonedLineSeqId = (String) value
				.get(FIELD_CART_ABANDONED_LINE_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		reservStart = (Timestamp) value.get(FIELD_RESERV_START);
		reservLength = (BigDecimal) value.get(FIELD_RESERV_LENGTH);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		reserv2ndPPPerc = (BigDecimal) value.get(FIELD_RESERV2ND_P_P_PERC);
		reservNthPPPerc = (BigDecimal) value.get(FIELD_RESERV_NTH_P_P_PERC);
		configId = (String) value.get(FIELD_CONFIG_ID);
		totalWithAdjustments = (BigDecimal) value
				.get(FIELD_TOTAL_WITH_ADJUSTMENTS);
		wasReserved = (String) value.get(FIELD_WAS_RESERVED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CartAbandonedLine fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CartAbandonedLine(value);
	}

	public static List<CartAbandonedLine> fromValues(List<GenericValue> values) {
		List<CartAbandonedLine> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CartAbandonedLine(value));
		}
		return entities;
	}
}