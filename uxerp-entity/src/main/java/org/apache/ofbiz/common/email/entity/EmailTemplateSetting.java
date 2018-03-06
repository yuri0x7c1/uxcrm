package org.apache.ofbiz.common.email.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Email Template Setting
 */
public class EmailTemplateSetting implements Serializable {

	public static final long serialVersionUID = 1200111531229073408L;
	public static final String NAME = "EmailTemplateSetting";
	/**
	 * Email Template Setting Id
	 */
	@Getter
	@Setter
	private String emailTemplateSettingId;
	/**
	 * Email Type
	 */
	@Getter
	@Setter
	private String emailType;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Body Screen Location
	 */
	@Getter
	@Setter
	private String bodyScreenLocation;
	/**
	 * Xslfo Attach Screen Location
	 */
	@Getter
	@Setter
	private String xslfoAttachScreenLocation;
	/**
	 * From Address
	 */
	@Getter
	@Setter
	private String fromAddress;
	/**
	 * Cc Address
	 */
	@Getter
	@Setter
	private String ccAddress;
	/**
	 * Bcc Address
	 */
	@Getter
	@Setter
	private String bccAddress;
	/**
	 * Subject
	 */
	@Getter
	@Setter
	private String subject;
	/**
	 * Content Type
	 */
	@Getter
	@Setter
	private String contentType;

	public enum Fields {
		emailTemplateSettingId, emailType, description, bodyScreenLocation, xslfoAttachScreenLocation, fromAddress, ccAddress, bccAddress, subject, contentType
	}

	public EmailTemplateSetting(GenericValue value) {
		emailTemplateSettingId = (String) value
				.get(Fields.emailTemplateSettingId.name());
		emailType = (String) value.get(Fields.emailType.name());
		description = (String) value.get(Fields.description.name());
		bodyScreenLocation = (String) value.get(Fields.bodyScreenLocation
				.name());
		xslfoAttachScreenLocation = (String) value
				.get(Fields.xslfoAttachScreenLocation.name());
		fromAddress = (String) value.get(Fields.fromAddress.name());
		ccAddress = (String) value.get(Fields.ccAddress.name());
		bccAddress = (String) value.get(Fields.bccAddress.name());
		subject = (String) value.get(Fields.subject.name());
		contentType = (String) value.get(Fields.contentType.name());
	}

	public static EmailTemplateSetting fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmailTemplateSetting(value);
	}

	public static List<EmailTemplateSetting> fromValues(
			List<GenericValue> values) {
		List<EmailTemplateSetting> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmailTemplateSetting(value));
		}
		return entities;
	}
}