package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Approval
 */
@FieldNameConstants
public class ContentApproval implements Serializable {

	public static final long serialVersionUID = 2778931923714912256L;
	public static final String NAME = "ContentApproval";
	/**
	 * Content Approval Id
	 */
	@Getter
	@Setter
	private String contentApprovalId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Revision Seq Id
	 */
	@Getter
	@Setter
	private String contentRevisionSeqId;
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
	 * Approval Status Id
	 */
	@Getter
	@Setter
	private String approvalStatusId;
	/**
	 * Approval Date
	 */
	@Getter
	@Setter
	private Timestamp approvalDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public ContentApproval(GenericValue value) {
		contentApprovalId = (String) value.get(FIELD_CONTENT_APPROVAL_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		approvalStatusId = (String) value.get(FIELD_APPROVAL_STATUS_ID);
		approvalDate = (Timestamp) value.get(FIELD_APPROVAL_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentApproval fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentApproval(value);
	}

	public static List<ContentApproval> fromValues(List<GenericValue> values) {
		List<ContentApproval> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentApproval(value));
		}
		return entities;
	}
}