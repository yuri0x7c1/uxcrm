package org.apache.ofbiz.product.price;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sale Type
 */
public class SaleType implements Serializable {

	public static final long serialVersionUID = 2169343870027892736L;
	public static final String NAME = "SaleType";
	/**
	 * Sale Type Id
	 */
	@Getter
	@Setter
	private String saleTypeId;
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
		saleTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SaleType(GenericValue value) {
		saleTypeId = (String) value.get(Fields.saleTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SaleType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new SaleType(value);
	}

	public static List<SaleType> fromValues(List<GenericValue> values) {
		List<SaleType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SaleType(value));
		}
		return entities;
	}
}