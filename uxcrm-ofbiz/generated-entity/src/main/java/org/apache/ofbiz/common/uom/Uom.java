package org.apache.ofbiz.common.uom;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Uom implements Serializable {

	public static final long serialVersionUID = 4482541498587563008L;
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

	public Uom(GenericValue value) {
		uomId = (String) value.get(FIELD_UOM_ID);
		uomTypeId = (String) value.get(FIELD_UOM_TYPE_ID);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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