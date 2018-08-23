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
 * Gl Xbrl Class
 */
@FieldNameConstants
public class GlXbrlClass implements Serializable {

	public static final long serialVersionUID = 8375190179996922880L;
	public static final String NAME = "GlXbrlClass";
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
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

	public GlXbrlClass(GenericValue value) {
		glXbrlClassId = (String) value.get(FIELD_GL_XBRL_CLASS_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlXbrlClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlXbrlClass(value);
	}

	public static List<GlXbrlClass> fromValues(List<GenericValue> values) {
		List<GlXbrlClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlXbrlClass(value));
		}
		return entities;
	}
}