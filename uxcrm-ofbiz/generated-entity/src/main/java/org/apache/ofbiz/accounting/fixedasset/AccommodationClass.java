package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Class
 */
@FieldNameConstants
public class AccommodationClass implements Serializable {

	public static final long serialVersionUID = 5890992108787476480L;
	public static final String NAME = "AccommodationClass";
	/**
	 * Accommodation Class Id
	 */
	@Getter
	@Setter
	private String accommodationClassId;
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

	public AccommodationClass(GenericValue value) {
		accommodationClassId = (String) value.get(FIELD_ACCOMMODATION_CLASS_ID);
		parentClassId = (String) value.get(FIELD_PARENT_CLASS_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AccommodationClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AccommodationClass(value);
	}

	public static List<AccommodationClass> fromValues(List<GenericValue> values) {
		List<AccommodationClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AccommodationClass(value));
		}
		return entities;
	}
}