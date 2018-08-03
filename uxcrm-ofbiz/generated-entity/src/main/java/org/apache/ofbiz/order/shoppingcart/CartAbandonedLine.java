package org.apache.ofbiz.order.shoppingcart;

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
public class CartAbandonedLine implements Serializable {

	public static final long serialVersionUID = 1831862463095090176L;
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

	public enum Fields {
		visitId, cartAbandonedLineSeqId, productId, prodCatalogId, quantity, reservStart, reservLength, reservPersons, unitPrice, reserv2ndPPPerc, reservNthPPPerc, configId, totalWithAdjustments, wasReserved, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CartAbandonedLine(GenericValue value) {
		visitId = (String) value.get(Fields.visitId.name());
		cartAbandonedLineSeqId = (String) value
				.get(Fields.cartAbandonedLineSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		configId = (String) value.get(Fields.configId.name());
		totalWithAdjustments = (BigDecimal) value
				.get(Fields.totalWithAdjustments.name());
		wasReserved = (String) value.get(Fields.wasReserved.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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