package org.apache.ofbiz.accounting.tax;

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
public class TaxAuthorityAssocType implements Serializable {

	public static final long serialVersionUID = 8889052438409627648L;
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

	public enum Fields {
		taxAuthorityAssocTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TaxAuthorityAssocType(GenericValue value) {
		taxAuthorityAssocTypeId = (String) value
				.get(Fields.taxAuthorityAssocTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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