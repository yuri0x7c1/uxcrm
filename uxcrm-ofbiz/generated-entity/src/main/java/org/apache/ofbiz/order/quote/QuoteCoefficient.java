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
 * Quote Coefficient
 */
public class QuoteCoefficient implements Serializable {

	public static final long serialVersionUID = 6545884055783446528L;
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

	public enum Fields {
		quoteId, coeffName, coeffValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuoteCoefficient(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		coeffName = (String) value.get(Fields.coeffName.name());
		coeffValue = (BigDecimal) value.get(Fields.coeffValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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