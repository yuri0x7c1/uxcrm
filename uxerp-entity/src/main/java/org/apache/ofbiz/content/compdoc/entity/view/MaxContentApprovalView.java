package org.apache.ofbiz.content.compdoc.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Max Content Approval View
 */
public class MaxContentApprovalView implements Serializable {

	public static final long serialVersionUID = 5516366914941982720L;
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

	public enum Fields {
		contentTypeId, contentId, partyId, roleTypeId, sequenceNum, contentRevisionSeqId
	}

	public MaxContentApprovalView(GenericValue value) {
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		contentId = (String) value.get(Fields.contentId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
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