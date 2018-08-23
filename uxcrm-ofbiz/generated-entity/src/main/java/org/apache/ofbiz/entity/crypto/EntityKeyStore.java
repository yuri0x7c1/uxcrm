package org.apache.ofbiz.entity.crypto;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Key Store
 */
@FieldNameConstants
public class EntityKeyStore implements Serializable {

	public static final long serialVersionUID = 6253456849407731712L;
	public static final String NAME = "EntityKeyStore";
	/**
	 * Key Name
	 */
	@Getter
	@Setter
	private String keyName;
	/**
	 * Key Text
	 */
	@Getter
	@Setter
	private String keyText;
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

	public EntityKeyStore(GenericValue value) {
		keyName = (String) value.get(FIELD_KEY_NAME);
		keyText = (String) value.get(FIELD_KEY_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EntityKeyStore fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntityKeyStore(value);
	}

	public static List<EntityKeyStore> fromValues(List<GenericValue> values) {
		List<EntityKeyStore> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntityKeyStore(value));
		}
		return entities;
	}
}