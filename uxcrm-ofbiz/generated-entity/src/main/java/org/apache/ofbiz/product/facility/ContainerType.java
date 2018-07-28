package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Container Type
 */
public class ContainerType implements Serializable {

	public static final long serialVersionUID = 6324115350742237184L;
	public static final String NAME = "ContainerType";
	/**
	 * Container Type Id
	 */
	@Getter
	@Setter
	private String containerTypeId;
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
		containerTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContainerType(GenericValue value) {
		containerTypeId = (String) value.get(Fields.containerTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContainerType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContainerType(value);
	}

	public static List<ContainerType> fromValues(List<GenericValue> values) {
		List<ContainerType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContainerType(value));
		}
		return entities;
	}
}