package org.apache.ofbiz.marketing.segment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group View Related Parties
 */
@FieldNameConstants
public class SegmentGroupViewRelatedParties implements Serializable {

	public static final long serialVersionUID = 3667643984689623040L;
	public static final String NAME = "SegmentGroupViewRelatedParties";
	/**
	 * Sgr Role Type Id
	 */
	@Getter
	@Setter
	private String sgrRoleTypeId;
	/**
	 * Sgr Segment Group Id
	 */
	@Getter
	@Setter
	private String sgrSegmentGroupId;
	/**
	 * Sgr Party Id
	 */
	@Getter
	@Setter
	private String sgrPartyId;
	/**
	 * Sgr To Role Type Id
	 */
	@Getter
	@Setter
	private String sgrToRoleTypeId;
	/**
	 * Sgr To Segment Group Id
	 */
	@Getter
	@Setter
	private String sgrToSegmentGroupId;
	/**
	 * Sgr To Party Id
	 */
	@Getter
	@Setter
	private String sgrToPartyId;
	/**
	 * Pr Sgr Role Type Id To
	 */
	@Getter
	@Setter
	private String prSgrRoleTypeIdTo;
	/**
	 * Pr Sgr Party Id From
	 */
	@Getter
	@Setter
	private String prSgrPartyIdFrom;
	/**
	 * Pr Sgr Position Title
	 */
	@Getter
	@Setter
	private String prSgrPositionTitle;
	/**
	 * Pr Sgr Comments
	 */
	@Getter
	@Setter
	private String prSgrComments;
	/**
	 * Pr Sgr Priority Type Id
	 */
	@Getter
	@Setter
	private String prSgrPriorityTypeId;
	/**
	 * Pr Sgr Permissions Enum Id
	 */
	@Getter
	@Setter
	private String prSgrPermissionsEnumId;
	/**
	 * Pr Sgr Role Type Id From
	 */
	@Getter
	@Setter
	private String prSgrRoleTypeIdFrom;
	/**
	 * Pr Sgr Thru Date
	 */
	@Getter
	@Setter
	private Timestamp prSgrThruDate;
	/**
	 * Pr Sgr From Date
	 */
	@Getter
	@Setter
	private Timestamp prSgrFromDate;
	/**
	 * Pr Sgr Relationship Name
	 */
	@Getter
	@Setter
	private String prSgrRelationshipName;
	/**
	 * Pr Sgr Security Group Id
	 */
	@Getter
	@Setter
	private String prSgrSecurityGroupId;
	/**
	 * Pr Sgr Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String prSgrPartyRelationshipTypeId;
	/**
	 * Pr Sgr Status Id
	 */
	@Getter
	@Setter
	private String prSgrStatusId;
	/**
	 * Pr Sgr Party Id To
	 */
	@Getter
	@Setter
	private String prSgrPartyIdTo;
	/**
	 * Sgc Party Classification Group Id
	 */
	@Getter
	@Setter
	private String sgcPartyClassificationGroupId;
	/**
	 * Sgc Segment Group Id
	 */
	@Getter
	@Setter
	private String sgcSegmentGroupId;
	/**
	 * Pc From Date
	 */
	@Getter
	@Setter
	private Timestamp pcFromDate;
	/**
	 * Pc Party Classification Group Id
	 */
	@Getter
	@Setter
	private String pcPartyClassificationGroupId;
	/**
	 * Pc Party Id
	 */
	@Getter
	@Setter
	private String pcPartyId;
	/**
	 * Pc Thru Date
	 */
	@Getter
	@Setter
	private Timestamp pcThruDate;
	/**
	 * Pr Pc Role Type Id To
	 */
	@Getter
	@Setter
	private String prPcRoleTypeIdTo;
	/**
	 * Pr Pc Party Id From
	 */
	@Getter
	@Setter
	private String prPcPartyIdFrom;
	/**
	 * Pr Pc Position Title
	 */
	@Getter
	@Setter
	private String prPcPositionTitle;
	/**
	 * Pr Pc Comments
	 */
	@Getter
	@Setter
	private String prPcComments;
	/**
	 * Pr Pc Priority Type Id
	 */
	@Getter
	@Setter
	private String prPcPriorityTypeId;
	/**
	 * Pr Pc Permissions Enum Id
	 */
	@Getter
	@Setter
	private String prPcPermissionsEnumId;
	/**
	 * Pr Pc Role Type Id From
	 */
	@Getter
	@Setter
	private String prPcRoleTypeIdFrom;
	/**
	 * Pr Pc Thru Date
	 */
	@Getter
	@Setter
	private Timestamp prPcThruDate;
	/**
	 * Pr Pc From Date
	 */
	@Getter
	@Setter
	private Timestamp prPcFromDate;
	/**
	 * Pr Pc Relationship Name
	 */
	@Getter
	@Setter
	private String prPcRelationshipName;
	/**
	 * Pr Pc Security Group Id
	 */
	@Getter
	@Setter
	private String prPcSecurityGroupId;
	/**
	 * Pr Pc Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String prPcPartyRelationshipTypeId;
	/**
	 * Pr Pc Status Id
	 */
	@Getter
	@Setter
	private String prPcStatusId;
	/**
	 * Pr Pc Party Id To
	 */
	@Getter
	@Setter
	private String prPcPartyIdTo;

	public SegmentGroupViewRelatedParties(GenericValue value) {
		sgrRoleTypeId = (String) value.get(FIELD_SGR_ROLE_TYPE_ID);
		sgrSegmentGroupId = (String) value.get(FIELD_SGR_SEGMENT_GROUP_ID);
		sgrPartyId = (String) value.get(FIELD_SGR_PARTY_ID);
		sgrToRoleTypeId = (String) value.get(FIELD_SGR_TO_ROLE_TYPE_ID);
		sgrToSegmentGroupId = (String) value.get(FIELD_SGR_TO_SEGMENT_GROUP_ID);
		sgrToPartyId = (String) value.get(FIELD_SGR_TO_PARTY_ID);
		prSgrRoleTypeIdTo = (String) value.get(FIELD_PR_SGR_ROLE_TYPE_ID_TO);
		prSgrPartyIdFrom = (String) value.get(FIELD_PR_SGR_PARTY_ID_FROM);
		prSgrPositionTitle = (String) value.get(FIELD_PR_SGR_POSITION_TITLE);
		prSgrComments = (String) value.get(FIELD_PR_SGR_COMMENTS);
		prSgrPriorityTypeId = (String) value.get(FIELD_PR_SGR_PRIORITY_TYPE_ID);
		prSgrPermissionsEnumId = (String) value
				.get(FIELD_PR_SGR_PERMISSIONS_ENUM_ID);
		prSgrRoleTypeIdFrom = (String) value
				.get(FIELD_PR_SGR_ROLE_TYPE_ID_FROM);
		prSgrThruDate = (Timestamp) value.get(FIELD_PR_SGR_THRU_DATE);
		prSgrFromDate = (Timestamp) value.get(FIELD_PR_SGR_FROM_DATE);
		prSgrRelationshipName = (String) value
				.get(FIELD_PR_SGR_RELATIONSHIP_NAME);
		prSgrSecurityGroupId = (String) value
				.get(FIELD_PR_SGR_SECURITY_GROUP_ID);
		prSgrPartyRelationshipTypeId = (String) value
				.get(FIELD_PR_SGR_PARTY_RELATIONSHIP_TYPE_ID);
		prSgrStatusId = (String) value.get(FIELD_PR_SGR_STATUS_ID);
		prSgrPartyIdTo = (String) value.get(FIELD_PR_SGR_PARTY_ID_TO);
		sgcPartyClassificationGroupId = (String) value
				.get(FIELD_SGC_PARTY_CLASSIFICATION_GROUP_ID);
		sgcSegmentGroupId = (String) value.get(FIELD_SGC_SEGMENT_GROUP_ID);
		pcFromDate = (Timestamp) value.get(FIELD_PC_FROM_DATE);
		pcPartyClassificationGroupId = (String) value
				.get(FIELD_PC_PARTY_CLASSIFICATION_GROUP_ID);
		pcPartyId = (String) value.get(FIELD_PC_PARTY_ID);
		pcThruDate = (Timestamp) value.get(FIELD_PC_THRU_DATE);
		prPcRoleTypeIdTo = (String) value.get(FIELD_PR_PC_ROLE_TYPE_ID_TO);
		prPcPartyIdFrom = (String) value.get(FIELD_PR_PC_PARTY_ID_FROM);
		prPcPositionTitle = (String) value.get(FIELD_PR_PC_POSITION_TITLE);
		prPcComments = (String) value.get(FIELD_PR_PC_COMMENTS);
		prPcPriorityTypeId = (String) value.get(FIELD_PR_PC_PRIORITY_TYPE_ID);
		prPcPermissionsEnumId = (String) value
				.get(FIELD_PR_PC_PERMISSIONS_ENUM_ID);
		prPcRoleTypeIdFrom = (String) value.get(FIELD_PR_PC_ROLE_TYPE_ID_FROM);
		prPcThruDate = (Timestamp) value.get(FIELD_PR_PC_THRU_DATE);
		prPcFromDate = (Timestamp) value.get(FIELD_PR_PC_FROM_DATE);
		prPcRelationshipName = (String) value
				.get(FIELD_PR_PC_RELATIONSHIP_NAME);
		prPcSecurityGroupId = (String) value.get(FIELD_PR_PC_SECURITY_GROUP_ID);
		prPcPartyRelationshipTypeId = (String) value
				.get(FIELD_PR_PC_PARTY_RELATIONSHIP_TYPE_ID);
		prPcStatusId = (String) value.get(FIELD_PR_PC_STATUS_ID);
		prPcPartyIdTo = (String) value.get(FIELD_PR_PC_PARTY_ID_TO);
	}

	public static SegmentGroupViewRelatedParties fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroupViewRelatedParties(value);
	}

	public static List<SegmentGroupViewRelatedParties> fromValues(
			List<GenericValue> values) {
		List<SegmentGroupViewRelatedParties> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroupViewRelatedParties(value));
		}
		return entities;
	}
}