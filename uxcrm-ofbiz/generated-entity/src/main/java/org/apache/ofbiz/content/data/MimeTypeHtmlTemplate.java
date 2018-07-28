package org.apache.ofbiz.content.data;

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
public class MimeTypeHtmlTemplate implements Serializable {

	public static final long serialVersionUID = 3965479336975152128L;
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

	public enum Fields {
		mimeTypeId, templateLocation, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MimeTypeHtmlTemplate(GenericValue value) {
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		templateLocation = (String) value.get(Fields.templateLocation.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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