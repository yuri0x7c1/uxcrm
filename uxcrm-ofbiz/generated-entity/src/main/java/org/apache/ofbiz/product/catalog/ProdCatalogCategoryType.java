package org.apache.ofbiz.product.catalog;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Category Type
 */
public class ProdCatalogCategoryType implements Serializable {

	public static final long serialVersionUID = 4910266773364122624L;
	public static final String NAME = "ProdCatalogCategoryType";
	/**
	 * Prod Catalog Category Type Id
	 */
	@Getter
	@Setter
	private String prodCatalogCategoryTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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
		prodCatalogCategoryTypeId, parentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProdCatalogCategoryType(GenericValue value) {
		prodCatalogCategoryTypeId = (String) value
				.get(Fields.prodCatalogCategoryTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProdCatalogCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogCategoryType(value);
	}

	public static List<ProdCatalogCategoryType> fromValues(
			List<GenericValue> values) {
		List<ProdCatalogCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogCategoryType(value));
		}
		return entities;
	}
}