package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Category
 */
@FieldNameConstants
public class TaxAuthorityCategory implements Serializable {

	public static final long serialVersionUID = 263635808232354816L;
	public static final String NAME = "TaxAuthorityCategory";
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
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

	public TaxAuthorityCategory(GenericValue value) {
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TaxAuthorityCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityCategory(value);
	}

	public static List<TaxAuthorityCategory> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityCategory(value));
		}
		return entities;
	}
}