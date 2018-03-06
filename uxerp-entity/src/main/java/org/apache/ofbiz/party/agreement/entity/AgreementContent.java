package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Content
 */
public class AgreementContent implements Serializable {

	public static final long serialVersionUID = 3247696440124709888L;
	public static final String NAME = "AgreementContent";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Agreement Content Type Id
	 */
	@Getter
	@Setter
	private String agreementContentTypeId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
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
		agreementId, agreementItemSeqId, agreementContentTypeId, contentId, fromDate, thruDate
	}

	public AgreementContent(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		agreementContentTypeId = (String) value
				.get(Fields.agreementContentTypeId.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static AgreementContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementContent(value);
	}

	public static List<AgreementContent> fromValues(List<GenericValue> values) {
		List<AgreementContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementContent(value));
		}
		return entities;
	}
}