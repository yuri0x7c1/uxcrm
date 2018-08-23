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
 * Gl Account
 */
@FieldNameConstants
public class GlAccount implements Serializable {

	public static final long serialVersionUID = 1041706246552033280L;
	public static final String NAME = "GlAccount";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
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

	public GlAccount(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		glResourceTypeId = (String) value.get(FIELD_GL_RESOURCE_TYPE_ID);
		glXbrlClassId = (String) value.get(FIELD_GL_XBRL_CLASS_ID);
		parentGlAccountId = (String) value.get(FIELD_PARENT_GL_ACCOUNT_ID);
		accountCode = (String) value.get(FIELD_ACCOUNT_CODE);
		accountName = (String) value.get(FIELD_ACCOUNT_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlAccount fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccount(value);
	}

	public static List<GlAccount> fromValues(List<GenericValue> values) {
		List<GlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccount(value));
		}
		return entities;
	}
}