package org.apache.ofbiz.accounting.ledger;

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
public class GlFiscalType implements Serializable {

	public static final long serialVersionUID = 7067037816463111168L;
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

	public enum Fields {
		glFiscalTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlFiscalType(GenericValue value) {
		glFiscalTypeId = (String) value.get(Fields.glFiscalTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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