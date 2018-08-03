package org.apache.ofbiz.product.catalog;

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
public class ProdCatalogInvFacility implements Serializable {

	public static final long serialVersionUID = 7940057551008710656L;
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

	public enum Fields {
		prodCatalogId, facilityId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProdCatalogInvFacility(GenericValue value) {
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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