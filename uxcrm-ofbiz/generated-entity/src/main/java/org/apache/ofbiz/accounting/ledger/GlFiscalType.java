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
 * Gl Fiscal Type
 */
@FieldNameConstants
public class GlFiscalType implements Serializable {

	public static final long serialVersionUID = 8316286923973616640L;
	public static final String NAME = "GlFiscalType";
	/**
	 * Gl Fiscal Type Id
	 */
	@Getter
	@Setter
	private String glFiscalTypeId;
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

	public GlFiscalType(GenericValue value) {
		glFiscalTypeId = (String) value.get(FIELD_GL_FISCAL_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlFiscalType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlFiscalType(value);
	}

	public static List<GlFiscalType> fromValues(List<GenericValue> values) {
		List<GlFiscalType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlFiscalType(value));
		}
		return entities;
	}
}