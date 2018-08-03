package org.apache.ofbiz.accounting.tax;

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
public class TaxAuthorityRateType implements Serializable {

	public static final long serialVersionUID = 2518858033813244928L;
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

	public enum Fields {
		taxAuthorityRateTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TaxAuthorityRateType(GenericValue value) {
		taxAuthorityRateTypeId = (String) value
				.get(Fields.taxAuthorityRateTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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