package org.apache.ofbiz.product.config;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Conf Item Content
 */
public class ProdConfItemContent implements Serializable {

	public static final long serialVersionUID = 9203344843058614272L;
	public static final String NAME = "ProdConfItemContent";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Conf Item Content Type Id
	 */
	@Getter
	@Setter
	private String confItemContentTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
		configItemId, contentId, confItemContentTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProdConfItemContent(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		contentId = (String) value.get(Fields.contentId.name());
		confItemContentTypeId = (String) value.get(Fields.confItemContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProdConfItemContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdConfItemContent(value);
	}

	public static List<ProdConfItemContent> fromValues(List<GenericValue> values) {
		List<ProdConfItemContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdConfItemContent(value));
		}
		return entities;
	}
}