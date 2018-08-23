package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class GlAccountCategoryMember implements Serializable {

	public static final long serialVersionUID = 5004730523265630208L;
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

	public GlAccountCategoryMember(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		glAccountCategoryId = (String) value.get(FIELD_GL_ACCOUNT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		amountPercentage = (BigDecimal) value.get(FIELD_AMOUNT_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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