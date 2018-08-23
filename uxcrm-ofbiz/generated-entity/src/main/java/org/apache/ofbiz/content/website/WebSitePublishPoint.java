package org.apache.ofbiz.content.website;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Publish Point
 */
@FieldNameConstants
public class WebSitePublishPoint implements Serializable {

	public static final long serialVersionUID = 5614367255598195712L;
	public static final String NAME = "WebSitePublishPoint";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Template Title
	 */
	@Getter
	@Setter
	private String templateTitle;
	/**
	 * Style Sheet File
	 */
	@Getter
	@Setter
	private String styleSheetFile;
	/**
	 * Logo
	 */
	@Getter
	@Setter
	private String logo;
	/**
	 * Medallion Logo
	 */
	@Getter
	@Setter
	private String medallionLogo;
	/**
	 * Line Logo
	 */
	@Getter
	@Setter
	private String lineLogo;
	/**
	 * Left Bar Id
	 */
	@Getter
	@Setter
	private String leftBarId;
	/**
	 * Right Bar Id
	 */
	@Getter
	@Setter
	private String rightBarId;
	/**
	 * Content Dept
	 */
	@Getter
	@Setter
	private String contentDept;
	/**
	 * About Content Id
	 */
	@Getter
	@Setter
	private String aboutContentId;
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

	public WebSitePublishPoint(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		templateTitle = (String) value.get(FIELD_TEMPLATE_TITLE);
		styleSheetFile = (String) value.get(FIELD_STYLE_SHEET_FILE);
		logo = (String) value.get(FIELD_LOGO);
		medallionLogo = (String) value.get(FIELD_MEDALLION_LOGO);
		lineLogo = (String) value.get(FIELD_LINE_LOGO);
		leftBarId = (String) value.get(FIELD_LEFT_BAR_ID);
		rightBarId = (String) value.get(FIELD_RIGHT_BAR_ID);
		contentDept = (String) value.get(FIELD_CONTENT_DEPT);
		aboutContentId = (String) value.get(FIELD_ABOUT_CONTENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WebSitePublishPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSitePublishPoint(value);
	}

	public static List<WebSitePublishPoint> fromValues(List<GenericValue> values) {
		List<WebSitePublishPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSitePublishPoint(value));
		}
		return entities;
	}
}