package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SaleType implements Serializable {

	public static final long serialVersionUID = 2023555837136449536L;
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

	public SaleType(GenericValue value) {
		saleTypeId = (String) value.get(FIELD_SALE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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