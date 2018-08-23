package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Category
 */
@FieldNameConstants
public class GlAccountCategory implements Serializable {

	public static final long serialVersionUID = 3751665830341036032L;
	public static final String NAME = "GlAccountCategory";
	/**
	 * Gl Account Category Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryId;
	/**
	 * Gl Account Category Type Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryTypeId;
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

	public GlAccountCategory(GenericValue value) {
		glAccountCategoryId = (String) value.get(FIELD_GL_ACCOUNT_CATEGORY_ID);
		glAccountCategoryTypeId = (String) value
				.get(FIELD_GL_ACCOUNT_CATEGORY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlAccountCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountCategory(value);
	}

	public static List<GlAccountCategory> fromValues(List<GenericValue> values) {
		List<GlAccountCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountCategory(value));
		}
		return entities;
	}
}