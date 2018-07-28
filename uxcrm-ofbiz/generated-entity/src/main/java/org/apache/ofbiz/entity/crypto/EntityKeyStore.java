package org.apache.ofbiz.entity.crypto;

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
public class EntityKeyStore implements Serializable {

	public static final long serialVersionUID = 7190601282013666304L;
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

	public enum Fields {
		keyName, keyText, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntityKeyStore(GenericValue value) {
		keyName = (String) value.get(Fields.keyName.name());
		keyText = (String) value.get(Fields.keyText.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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