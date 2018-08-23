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
 * Prod Catalog
 */
@FieldNameConstants
public class ProdCatalog implements Serializable {

	public static final long serialVersionUID = 7481823803174556672L;
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

	public ProdCatalog(GenericValue value) {
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		catalogName = (String) value.get(FIELD_CATALOG_NAME);
		useQuickAdd = (String) value.get(FIELD_USE_QUICK_ADD);
		styleSheet = (String) value.get(FIELD_STYLE_SHEET);
		headerLogo = (String) value.get(FIELD_HEADER_LOGO);
		contentPathPrefix = (String) value.get(FIELD_CONTENT_PATH_PREFIX);
		templatePathPrefix = (String) value.get(FIELD_TEMPLATE_PATH_PREFIX);
		viewAllowPermReqd = (String) value.get(FIELD_VIEW_ALLOW_PERM_REQD);
		purchaseAllowPermReqd = (String) value
				.get(FIELD_PURCHASE_ALLOW_PERM_REQD);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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