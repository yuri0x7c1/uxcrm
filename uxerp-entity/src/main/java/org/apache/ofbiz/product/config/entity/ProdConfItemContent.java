package org.apache.ofbiz.product.config.entity;

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

	public static final long serialVersionUID = 6932562829297920000L;
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

	public enum Fields {
		configItemId, contentId, confItemContentTypeId, fromDate, thruDate
	}

	public ProdConfItemContent(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		contentId = (String) value.get(Fields.contentId.name());
		confItemContentTypeId = (String) value.get(Fields.confItemContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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