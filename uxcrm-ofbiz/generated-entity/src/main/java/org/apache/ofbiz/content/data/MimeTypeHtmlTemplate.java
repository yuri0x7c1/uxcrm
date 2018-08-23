package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mime Type Html Template
 */
@FieldNameConstants
public class MimeTypeHtmlTemplate implements Serializable {

	public static final long serialVersionUID = 430425082053092352L;
	public static final String NAME = "MimeTypeHtmlTemplate";
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Template Location
	 */
	@Getter
	@Setter
	private String templateLocation;
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

	public MimeTypeHtmlTemplate(GenericValue value) {
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		templateLocation = (String) value.get(FIELD_TEMPLATE_LOCATION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static MimeTypeHtmlTemplate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MimeTypeHtmlTemplate(value);
	}

	public static List<MimeTypeHtmlTemplate> fromValues(
			List<GenericValue> values) {
		List<MimeTypeHtmlTemplate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MimeTypeHtmlTemplate(value));
		}
		return entities;
	}
}