package org.apache.ofbiz.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

/**
 * Java Resource
 */
public class JavaResource implements Serializable {

	public static final long serialVersionUID = 6897783070034802688L;
	public static final String NAME = "JavaResource";
	/**
	 * Resource Name
	 */
	@Getter
	@Setter
	private String resourceName;
	/**
	 * Resource Value
	 */
	@Getter
	@Setter
	private byte[] resourceValue;
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
		resourceName, resourceValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public JavaResource(org.apache.ofbiz.entity.GenericValue value) {
		resourceName = (String) value.get(Fields.resourceName.name());
		resourceValue = (byte[]) value.get(Fields.resourceValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static JavaResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JavaResource(value);
	}

	public static List<JavaResource> fromValues(List<GenericValue> values) {
		List<JavaResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JavaResource(value));
		}
		return entities;
	}
}