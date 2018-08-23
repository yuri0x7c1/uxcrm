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
 * Quote Coefficient
 */
@FieldNameConstants
public class QuoteCoefficient implements Serializable {

	public static final long serialVersionUID = 244271953042716672L;
	public static final String NAME = "QuoteCoefficient";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Coeff Name
	 */
	@Getter
	@Setter
	private String coeffName;
	/**
	 * Coeff Value
	 */
	@Getter
	@Setter
	private BigDecimal coeffValue;
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

	public QuoteCoefficient(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		coeffName = (String) value.get(FIELD_COEFF_NAME);
		coeffValue = (BigDecimal) value.get(FIELD_COEFF_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static QuoteCoefficient fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteCoefficient(value);
	}

	public static List<QuoteCoefficient> fromValues(List<GenericValue> values) {
		List<QuoteCoefficient> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteCoefficient(value));
		}
		return entities;
	}
}