package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Organization And Class
 */
@FieldNameConstants
public class GlAccountOrganizationAndClass implements Serializable {

	public static final long serialVersionUID = 4060342266225116160L;
	public static final String NAME = "GlAccountOrganizationAndClass";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Parent Gl Account Id
	 */
	@Getter
	@Setter
	private String parentGlAccountId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;

	public GlAccountOrganizationAndClass(GenericValue value) {
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		accountCode = (String) value.get(FIELD_ACCOUNT_CODE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		accountName = (String) value.get(FIELD_ACCOUNT_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		glResourceTypeId = (String) value.get(FIELD_GL_RESOURCE_TYPE_ID);
		parentGlAccountId = (String) value.get(FIELD_PARENT_GL_ACCOUNT_ID);
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		glXbrlClassId = (String) value.get(FIELD_GL_XBRL_CLASS_ID);
	}

	public static GlAccountOrganizationAndClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountOrganizationAndClass(value);
	}

	public static List<GlAccountOrganizationAndClass> fromValues(
			List<GenericValue> values) {
		List<GlAccountOrganizationAndClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountOrganizationAndClass(value));
		}
		return entities;
	}
}