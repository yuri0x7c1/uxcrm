package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Vendor
 */
@FieldNameConstants
public class Vendor implements Serializable {

	public static final long serialVersionUID = 4064981426263387136L;
	public static final String NAME = "Vendor";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Manifest Company Name
	 */
	@Getter
	@Setter
	private String manifestCompanyName;
	/**
	 * Manifest Company Title
	 */
	@Getter
	@Setter
	private String manifestCompanyTitle;
	/**
	 * Manifest Logo Url
	 */
	@Getter
	@Setter
	private String manifestLogoUrl;
	/**
	 * Manifest Policies
	 */
	@Getter
	@Setter
	private String manifestPolicies;
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

	public Vendor(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		manifestCompanyName = (String) value.get(FIELD_MANIFEST_COMPANY_NAME);
		manifestCompanyTitle = (String) value.get(FIELD_MANIFEST_COMPANY_TITLE);
		manifestLogoUrl = (String) value.get(FIELD_MANIFEST_LOGO_URL);
		manifestPolicies = (String) value.get(FIELD_MANIFEST_POLICIES);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Vendor fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Vendor(value);
	}

	public static List<Vendor> fromValues(List<GenericValue> values) {
		List<Vendor> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Vendor(value));
		}
		return entities;
	}
}