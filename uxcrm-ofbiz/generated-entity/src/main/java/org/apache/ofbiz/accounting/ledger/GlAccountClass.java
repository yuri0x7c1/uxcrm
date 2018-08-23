package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Class
 */
@FieldNameConstants
public class GlAccountClass implements Serializable {

	public static final long serialVersionUID = 8007492016546562048L;
	public static final String NAME = "GlAccountClass";
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Parent Class Id
	 */
	@Getter
	@Setter
	private String parentClassId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Asset Class
	 */
	@Getter
	@Setter
	private String isAssetClass;
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

	public GlAccountClass(GenericValue value) {
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		parentClassId = (String) value.get(FIELD_PARENT_CLASS_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		isAssetClass = (String) value.get(FIELD_IS_ASSET_CLASS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlAccountClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountClass(value);
	}

	public static List<GlAccountClass> fromValues(List<GenericValue> values) {
		List<GlAccountClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountClass(value));
		}
		return entities;
	}
}