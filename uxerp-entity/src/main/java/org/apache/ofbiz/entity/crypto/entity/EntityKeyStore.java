package org.apache.ofbiz.entity.crypto.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Key Store
 */
public class EntityKeyStore implements Serializable {

	public static final long serialVersionUID = 6796904921546497024L;
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

	public enum Fields {
		keyName, keyText
	}

	public EntityKeyStore(GenericValue value) {
		keyName = (String) value.get(Fields.keyName.name());
		keyText = (String) value.get(Fields.keyText.name());
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