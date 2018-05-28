package org.apache.ofbiz.marketing.segment;

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
public class SegmentGroupViewRelatedParties implements Serializable {

	public static final long serialVersionUID = 4599369474211658752L;
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

	public enum Fields {
		sgrRoleTypeId, sgrSegmentGroupId, sgrPartyId, sgrToRoleTypeId, sgrToSegmentGroupId, sgrToPartyId, prSgrRoleTypeIdTo, prSgrPartyIdFrom, prSgrPositionTitle, prSgrComments, prSgrPriorityTypeId, prSgrPermissionsEnumId, prSgrRoleTypeIdFrom, prSgrThruDate, prSgrFromDate, prSgrRelationshipName, prSgrSecurityGroupId, prSgrPartyRelationshipTypeId, prSgrStatusId, prSgrPartyIdTo, sgcPartyClassificationGroupId, sgcSegmentGroupId, pcFromDate, pcPartyClassificationGroupId, pcPartyId, pcThruDate, prPcRoleTypeIdTo, prPcPartyIdFrom, prPcPositionTitle, prPcComments, prPcPriorityTypeId, prPcPermissionsEnumId, prPcRoleTypeIdFrom, prPcThruDate, prPcFromDate, prPcRelationshipName, prPcSecurityGroupId, prPcPartyRelationshipTypeId, prPcStatusId, prPcPartyIdTo
	}

	public SegmentGroupViewRelatedParties(GenericValue value) {
		sgrRoleTypeId = (String) value.get(Fields.sgrRoleTypeId.name());
		sgrSegmentGroupId = (String) value.get(Fields.sgrSegmentGroupId.name());
		sgrPartyId = (String) value.get(Fields.sgrPartyId.name());
		sgrToRoleTypeId = (String) value.get(Fields.sgrToRoleTypeId.name());
		sgrToSegmentGroupId = (String) value.get(Fields.sgrToSegmentGroupId
				.name());
		sgrToPartyId = (String) value.get(Fields.sgrToPartyId.name());
		prSgrRoleTypeIdTo = (String) value.get(Fields.prSgrRoleTypeIdTo.name());
		prSgrPartyIdFrom = (String) value.get(Fields.prSgrPartyIdFrom.name());
		prSgrPositionTitle = (String) value.get(Fields.prSgrPositionTitle
				.name());
		prSgrComments = (String) value.get(Fields.prSgrComments.name());
		prSgrPriorityTypeId = (String) value.get(Fields.prSgrPriorityTypeId
				.name());
		prSgrPermissionsEnumId = (String) value
				.get(Fields.prSgrPermissionsEnumId.name());
		prSgrRoleTypeIdFrom = (String) value.get(Fields.prSgrRoleTypeIdFrom
				.name());
		prSgrThruDate = (Timestamp) value.get(Fields.prSgrThruDate.name());
		prSgrFromDate = (Timestamp) value.get(Fields.prSgrFromDate.name());
		prSgrRelationshipName = (String) value.get(Fields.prSgrRelationshipName
				.name());
		prSgrSecurityGroupId = (String) value.get(Fields.prSgrSecurityGroupId
				.name());
		prSgrPartyRelationshipTypeId = (String) value
				.get(Fields.prSgrPartyRelationshipTypeId.name());
		prSgrStatusId = (String) value.get(Fields.prSgrStatusId.name());
		prSgrPartyIdTo = (String) value.get(Fields.prSgrPartyIdTo.name());
		sgcPartyClassificationGroupId = (String) value
				.get(Fields.sgcPartyClassificationGroupId.name());
		sgcSegmentGroupId = (String) value.get(Fields.sgcSegmentGroupId.name());
		pcFromDate = (Timestamp) value.get(Fields.pcFromDate.name());
		pcPartyClassificationGroupId = (String) value
				.get(Fields.pcPartyClassificationGroupId.name());
		pcPartyId = (String) value.get(Fields.pcPartyId.name());
		pcThruDate = (Timestamp) value.get(Fields.pcThruDate.name());
		prPcRoleTypeIdTo = (String) value.get(Fields.prPcRoleTypeIdTo.name());
		prPcPartyIdFrom = (String) value.get(Fields.prPcPartyIdFrom.name());
		prPcPositionTitle = (String) value.get(Fields.prPcPositionTitle.name());
		prPcComments = (String) value.get(Fields.prPcComments.name());
		prPcPriorityTypeId = (String) value.get(Fields.prPcPriorityTypeId
				.name());
		prPcPermissionsEnumId = (String) value.get(Fields.prPcPermissionsEnumId
				.name());
		prPcRoleTypeIdFrom = (String) value.get(Fields.prPcRoleTypeIdFrom
				.name());
		prPcThruDate = (Timestamp) value.get(Fields.prPcThruDate.name());
		prPcFromDate = (Timestamp) value.get(Fields.prPcFromDate.name());
		prPcRelationshipName = (String) value.get(Fields.prPcRelationshipName
				.name());
		prPcSecurityGroupId = (String) value.get(Fields.prPcSecurityGroupId
				.name());
		prPcPartyRelationshipTypeId = (String) value
				.get(Fields.prPcPartyRelationshipTypeId.name());
		prPcStatusId = (String) value.get(Fields.prPcStatusId.name());
		prPcPartyIdTo = (String) value.get(Fields.prPcPartyIdTo.name());
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