package org.apache.ofbiz.order.quote;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Item
 */
public class QuoteItem implements Serializable {

	public static final long serialVersionUID = 4869766910036794368L;
	public static final String NAME = "QuoteItem";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Quote Item Seq Id
	 */
	@Getter
	@Setter
	private String quoteItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
	/**
	 * Skill Type Id
	 */
	@Getter
	@Setter
	private String skillTypeId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Selected Amount
	 */
	@Getter
	@Setter
	private BigDecimal selectedAmount;
	/**
	 * Quote Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal quoteUnitPrice;
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
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Is Promo
	 */
	@Getter
	@Setter
	private String isPromo;
	/**
	 * Lead Time Days
	 */
	@Getter
	@Setter
	private Long leadTimeDays;
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
		quoteId, quoteItemSeqId, productId, productFeatureId, deliverableTypeId, skillTypeId, uomId, workEffortId, custRequestId, custRequestItemSeqId, quantity, selectedAmount, quoteUnitPrice, reservStart, reservLength, reservPersons, configId, estimatedDeliveryDate, comments, isPromo, leadTimeDays, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuoteItem(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		quoteItemSeqId = (String) value.get(Fields.quoteItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		deliverableTypeId = (String) value.get(Fields.deliverableTypeId.name());
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		uomId = (String) value.get(Fields.uomId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
		quoteUnitPrice = (BigDecimal) value.get(Fields.quoteUnitPrice.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		configId = (String) value.get(Fields.configId.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
		comments = (String) value.get(Fields.comments.name());
		isPromo = (String) value.get(Fields.isPromo.name());
		leadTimeDays = (Long) value.get(Fields.leadTimeDays.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static QuoteItem fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteItem(value);
	}

	public static List<QuoteItem> fromValues(List<GenericValue> values) {
		List<QuoteItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteItem(value));
		}
		return entities;
	}
}