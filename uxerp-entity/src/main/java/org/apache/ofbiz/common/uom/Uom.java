package org.apache.ofbiz.common.uom;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom
 */
public class Uom implements Serializable {

	public static final long serialVersionUID = 3594940533092597760L;
	public static final String NAME = "Uom";
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Uom Type Id
	 */
	@Getter
	@Setter
	private String uomTypeId;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Numeric Code
	 */
	@Getter
	@Setter
	private Long numericCode;
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
		uomId, uomTypeId, abbreviation, numericCode, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Uom(GenericValue value) {
		uomId = (String) value.get(Fields.uomId.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		numericCode = (Long) value.get(Fields.numericCode.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Uom fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Uom(value);
	}

	public static List<Uom> fromValues(List<GenericValue> values) {
		List<Uom> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Uom(value));
		}
		return entities;
	}
}