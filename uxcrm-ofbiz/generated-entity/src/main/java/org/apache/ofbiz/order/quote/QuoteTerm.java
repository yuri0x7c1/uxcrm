package org.apache.ofbiz.order.quote;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Term
 */
@FieldNameConstants
public class QuoteTerm implements Serializable {

	public static final long serialVersionUID = 8067739701842466816L;
	public static final String NAME = "QuoteTerm";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
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
	 * Term Value
	 */
	@Getter
	@Setter
	private Long termValue;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Term Days
	 */
	@Getter
	@Setter
	private Long termDays;
	/**
	 * Text Value
	 */
	@Getter
	@Setter
	private String textValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public QuoteTerm(GenericValue value) {
		termTypeId = (String) value.get(FIELD_TERM_TYPE_ID);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		termValue = (Long) value.get(FIELD_TERM_VALUE);
		uomId = (String) value.get(FIELD_UOM_ID);
		termDays = (Long) value.get(FIELD_TERM_DAYS);
		textValue = (String) value.get(FIELD_TEXT_VALUE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static QuoteTerm fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteTerm(value);
	}

	public static List<QuoteTerm> fromValues(List<GenericValue> values) {
		List<QuoteTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteTerm(value));
		}
		return entities;
	}
}