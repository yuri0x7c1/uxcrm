package org.apache.ofbiz.accounting.tax;

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
public class TaxAuthorityCategory implements Serializable {

	public static final long serialVersionUID = 8510002534402587648L;
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

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, productCategoryId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TaxAuthorityCategory(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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