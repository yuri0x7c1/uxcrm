package org.apache.ofbiz.order.quote;

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
 * Quote Item
 */
@FieldNameConstants
public class QuoteItem implements Serializable {

	public static final long serialVersionUID = 7891538871061140480L;
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

	public QuoteItem(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		deliverableTypeId = (String) value.get(FIELD_DELIVERABLE_TYPE_ID);
		skillTypeId = (String) value.get(FIELD_SKILL_TYPE_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		quoteUnitPrice = (BigDecimal) value.get(FIELD_QUOTE_UNIT_PRICE);
		reservStart = (Timestamp) value.get(FIELD_RESERV_START);
		reservLength = (BigDecimal) value.get(FIELD_RESERV_LENGTH);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		configId = (String) value.get(FIELD_CONFIG_ID);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		isPromo = (String) value.get(FIELD_IS_PROMO);
		leadTimeDays = (Long) value.get(FIELD_LEAD_TIME_DAYS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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