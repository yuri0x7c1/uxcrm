package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Category Member
 */
public class GlAccountCategoryMember implements Serializable {

	public static final long serialVersionUID = 8847665490362954752L;
	public static final String NAME = "GlAccountCategoryMember";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Category Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Amount Percentage
	 */
	@Getter
	@Setter
	private BigDecimal amountPercentage;
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
		glAccountId, glAccountCategoryId, fromDate, thruDate, amountPercentage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountCategoryMember(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountCategoryId = (String) value.get(Fields.glAccountCategoryId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		amountPercentage = (BigDecimal) value.get(Fields.amountPercentage
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlAccountCategoryMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountCategoryMember(value);
	}

	public static List<GlAccountCategoryMember> fromValues(
			List<GenericValue> values) {
		List<GlAccountCategoryMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountCategoryMember(value));
		}
		return entities;
	}
}