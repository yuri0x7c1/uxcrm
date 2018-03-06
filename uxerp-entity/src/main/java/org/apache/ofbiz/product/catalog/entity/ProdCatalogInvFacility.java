package org.apache.ofbiz.product.catalog.entity;

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

	public static final long serialVersionUID = 5813998001134967808L;
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

	public enum Fields {
		prodCatalogId, facilityId, fromDate, thruDate, sequenceNum
	}

	public ProdCatalogInvFacility(GenericValue value) {
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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