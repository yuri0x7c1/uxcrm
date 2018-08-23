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
 * Tax Authority Assoc Type
 */
@FieldNameConstants
public class TaxAuthorityAssocType implements Serializable {

	public static final long serialVersionUID = 3482153879025014784L;
	public static final String NAME = "TaxAuthorityAssocType";
	/**
	 * Tax Authority Assoc Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityAssocTypeId;
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

	public TaxAuthorityAssocType(GenericValue value) {
		taxAuthorityAssocTypeId = (String) value
				.get(FIELD_TAX_AUTHORITY_ASSOC_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TaxAuthorityAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityAssocType(value);
	}

	public static List<TaxAuthorityAssocType> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityAssocType(value));
		}
		return entities;
	}
}