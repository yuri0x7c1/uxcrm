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
 * Tax Authority Rate Type
 */
@FieldNameConstants
public class TaxAuthorityRateType implements Serializable {

	public static final long serialVersionUID = 1040757391888666624L;
	public static final String NAME = "TaxAuthorityRateType";
	/**
	 * Tax Authority Rate Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateTypeId;
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

	public TaxAuthorityRateType(GenericValue value) {
		taxAuthorityRateTypeId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TaxAuthorityRateType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityRateType(value);
	}

	public static List<TaxAuthorityRateType> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityRateType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityRateType(value));
		}
		return entities;
	}
}