package org.apache.ofbiz.content.content.entity;

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
public class ContentApproval implements Serializable {

	public static final long serialVersionUID = 2434608036933689344L;
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

	public enum Fields {
		contentApprovalId, contentId, contentRevisionSeqId, partyId, roleTypeId, approvalStatusId, approvalDate, sequenceNum, comments
	}

	public ContentApproval(GenericValue value) {
		contentApprovalId = (String) value.get(Fields.contentApprovalId.name());
		contentId = (String) value.get(Fields.contentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		approvalStatusId = (String) value.get(Fields.approvalStatusId.name());
		approvalDate = (Timestamp) value.get(Fields.approvalDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		comments = (String) value.get(Fields.comments.name());
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