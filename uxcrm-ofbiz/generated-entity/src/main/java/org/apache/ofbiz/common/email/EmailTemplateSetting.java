package org.apache.ofbiz.common.email;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Email Template Setting
 */
@FieldNameConstants
public class EmailTemplateSetting implements Serializable {

	public static final long serialVersionUID = 8965995970202221568L;
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

	public EmailTemplateSetting(GenericValue value) {
		emailTemplateSettingId = (String) value
				.get(FIELD_EMAIL_TEMPLATE_SETTING_ID);
		emailType = (String) value.get(FIELD_EMAIL_TYPE);
		description = (String) value.get(FIELD_DESCRIPTION);
		bodyScreenLocation = (String) value.get(FIELD_BODY_SCREEN_LOCATION);
		xslfoAttachScreenLocation = (String) value
				.get(FIELD_XSLFO_ATTACH_SCREEN_LOCATION);
		fromAddress = (String) value.get(FIELD_FROM_ADDRESS);
		ccAddress = (String) value.get(FIELD_CC_ADDRESS);
		bccAddress = (String) value.get(FIELD_BCC_ADDRESS);
		subject = (String) value.get(FIELD_SUBJECT);
		contentType = (String) value.get(FIELD_CONTENT_TYPE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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