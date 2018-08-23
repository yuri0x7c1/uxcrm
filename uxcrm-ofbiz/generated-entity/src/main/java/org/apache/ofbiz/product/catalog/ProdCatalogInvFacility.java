package org.apache.ofbiz.product.catalog;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Inv Facility
 */
@FieldNameConstants
public class ProdCatalogInvFacility implements Serializable {

	public static final long serialVersionUID = 3390100864034720768L;
	public static final String NAME = "ProdCatalogInvFacility";
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public ProdCatalogInvFacility(GenericValue value) {
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProdCatalogInvFacility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogInvFacility(value);
	}

	public static List<ProdCatalogInvFacility> fromValues(
			List<GenericValue> values) {
		List<ProdCatalogInvFacility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogInvFacility(value));
		}
		return entities;
	}
}