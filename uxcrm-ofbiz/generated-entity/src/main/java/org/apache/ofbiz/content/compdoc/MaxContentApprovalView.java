package org.apache.ofbiz.content.compdoc;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Max Content Approval View
 */
@FieldNameConstants
public class MaxContentApprovalView implements Serializable {

	public static final long serialVersionUID = 4229157523262626816L;
	public static final String NAME = "MaxContentApprovalView";
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Content Revision Seq Id
	 */
	@Getter
	@Setter
	private String contentRevisionSeqId;
	/**
	 * Max Content Revision Seq Id
	 */
	@Getter
	@Setter
	private String maxContentRevisionSeqId;

	public MaxContentApprovalView(GenericValue value) {
		contentTypeId = (String) value.get(FIELD_CONTENT_TYPE_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		maxContentRevisionSeqId = (String) value
				.get(FIELD_MAX_CONTENT_REVISION_SEQ_ID);
	}

	public static MaxContentApprovalView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MaxContentApprovalView(value);
	}

	public static List<MaxContentApprovalView> fromValues(
			List<GenericValue> values) {
		List<MaxContentApprovalView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MaxContentApprovalView(value));
		}
		return entities;
	}
}