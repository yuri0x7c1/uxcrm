package org.apache.ofbiz.product.supplier;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Supplier Rating Type
 */
public class SupplierRatingType implements Serializable {

	public static final long serialVersionUID = 1010182119033527296L;
	public static final String NAME = "SupplierRatingType";
	/**
	 * Supplier Rating Type Id
	 */
	@Getter
	@Setter
	private String supplierRatingTypeId;
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
		supplierRatingTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SupplierRatingType(GenericValue value) {
		supplierRatingTypeId = (String) value.get(Fields.supplierRatingTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SupplierRatingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierRatingType(value);
	}

	public static List<SupplierRatingType> fromValues(List<GenericValue> values) {
		List<SupplierRatingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierRatingType(value));
		}
		return entities;
	}
}