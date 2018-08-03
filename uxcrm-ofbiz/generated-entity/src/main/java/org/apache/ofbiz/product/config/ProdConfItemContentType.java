package org.apache.ofbiz.product.config;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Conf Item Content Type
 */
public class ProdConfItemContentType implements Serializable {

	public static final long serialVersionUID = 7271283202647937024L;
	public static final String NAME = "ProdConfItemContentType";
	/**
	 * Conf Item Content Type Id
	 */
	@Getter
	@Setter
	private String confItemContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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
		confItemContentTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProdConfItemContentType(GenericValue value) {
		confItemContentTypeId = (String) value.get(Fields.confItemContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProdConfItemContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdConfItemContentType(value);
	}

	public static List<ProdConfItemContentType> fromValues(
			List<GenericValue> values) {
		List<ProdConfItemContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdConfItemContentType(value));
		}
		return entities;
	}
}