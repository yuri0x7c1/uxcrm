package org.apache.ofbiz.product.catalog.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Role
 */
public class ProdCatalogRole implements Serializable {

	public static final long serialVersionUID = 7540992306397384704L;
	public static final String NAME = "ProdCatalogRole";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
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
		partyId, roleTypeId, prodCatalogId, fromDate, thruDate, sequenceNum
	}

	public ProdCatalogRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProdCatalogRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogRole(value);
	}

	public static List<ProdCatalogRole> fromValues(List<GenericValue> values) {
		List<ProdCatalogRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogRole(value));
		}
		return entities;
	}
}