package org.apache.ofbiz.product.catalog.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog
 */
public class ProdCatalog implements Serializable {

	public static final long serialVersionUID = 6391125454597412864L;
	public static final String NAME = "ProdCatalog";
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Catalog Name
	 */
	@Getter
	@Setter
	private String catalogName;
	/**
	 * Use Quick Add
	 */
	@Getter
	@Setter
	private String useQuickAdd;
	/**
	 * Style Sheet
	 */
	@Getter
	@Setter
	private String styleSheet;
	/**
	 * Header Logo
	 */
	@Getter
	@Setter
	private String headerLogo;
	/**
	 * Content Path Prefix
	 */
	@Getter
	@Setter
	private String contentPathPrefix;
	/**
	 * Template Path Prefix
	 */
	@Getter
	@Setter
	private String templatePathPrefix;
	/**
	 * View Allow Perm Reqd
	 */
	@Getter
	@Setter
	private String viewAllowPermReqd;
	/**
	 * Purchase Allow Perm Reqd
	 */
	@Getter
	@Setter
	private String purchaseAllowPermReqd;

	public enum Fields {
		prodCatalogId, catalogName, useQuickAdd, styleSheet, headerLogo, contentPathPrefix, templatePathPrefix, viewAllowPermReqd, purchaseAllowPermReqd
	}

	public ProdCatalog(GenericValue value) {
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		catalogName = (String) value.get(Fields.catalogName.name());
		useQuickAdd = (String) value.get(Fields.useQuickAdd.name());
		styleSheet = (String) value.get(Fields.styleSheet.name());
		headerLogo = (String) value.get(Fields.headerLogo.name());
		contentPathPrefix = (String) value.get(Fields.contentPathPrefix.name());
		templatePathPrefix = (String) value.get(Fields.templatePathPrefix
				.name());
		viewAllowPermReqd = (String) value.get(Fields.viewAllowPermReqd.name());
		purchaseAllowPermReqd = (String) value.get(Fields.purchaseAllowPermReqd
				.name());
	}

	public static ProdCatalog fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalog(value);
	}

	public static List<ProdCatalog> fromValues(List<GenericValue> values) {
		List<ProdCatalog> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalog(value));
		}
		return entities;
	}
}