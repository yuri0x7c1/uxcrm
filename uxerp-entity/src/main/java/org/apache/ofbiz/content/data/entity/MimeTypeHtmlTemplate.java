package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mime Type Html Template
 */
public class MimeTypeHtmlTemplate implements Serializable {

	public static final long serialVersionUID = 6621018023744398336L;
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

	public enum Fields {
		mimeTypeId, templateLocation
	}

	public MimeTypeHtmlTemplate(GenericValue value) {
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		templateLocation = (String) value.get(Fields.templateLocation.name());
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