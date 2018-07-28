package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Task List
 */
public class OrderTaskList implements Serializable {

	public static final long serialVersionUID = 2647252124602237952L;
	public static final String NAME = "OrderTaskList";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Order Role Type Id
	 */
	@Getter
	@Setter
	private String orderRoleTypeId;
	/**
	 * Customer Party Id
	 */
	@Getter
	@Setter
	private String customerPartyId;
	/**
	 * Customer First Name
	 */
	@Getter
	@Setter
	private String customerFirstName;
	/**
	 * Customer Last Name
	 */
	@Getter
	@Setter
	private String customerLastName;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Last Status Update
	 */
	@Getter
	@Setter
	private Timestamp lastStatusUpdate;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Info Url
	 */
	@Getter
	@Setter
	private String infoUrl;
	/**
	 * Wepa Party Id
	 */
	@Getter
	@Setter
	private String wepaPartyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date Time
	 */
	@Getter
	@Setter
	private Timestamp statusDateTime;

	public enum Fields {
		orderId, orderTypeId, orderDate, entryDate, grandTotal, orderRoleTypeId, customerPartyId, customerFirstName, customerLastName, workEffortId, workEffortTypeId, currentStatusId, lastStatusUpdate, priority, workEffortName, description, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, estimatedStartDate, estimatedCompletionDate, actualStartDate, actualCompletionDate, infoUrl, wepaPartyId, roleTypeId, fromDate, thruDate, statusId, statusDateTime
	}

	public OrderTaskList(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		orderRoleTypeId = (String) value.get(Fields.orderRoleTypeId.name());
		customerPartyId = (String) value.get(Fields.customerPartyId.name());
		customerFirstName = (String) value.get(Fields.customerFirstName.name());
		customerLastName = (String) value.get(Fields.customerLastName.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		lastStatusUpdate = (Timestamp) value
				.get(Fields.lastStatusUpdate.name());
		priority = (Long) value.get(Fields.priority.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		description = (String) value.get(Fields.description.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		estimatedCompletionDate = (Timestamp) value
				.get(Fields.estimatedCompletionDate.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		actualCompletionDate = (Timestamp) value
				.get(Fields.actualCompletionDate.name());
		infoUrl = (String) value.get(Fields.infoUrl.name());
		wepaPartyId = (String) value.get(Fields.wepaPartyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDateTime = (Timestamp) value.get(Fields.statusDateTime.name());
	}

	public static OrderTaskList fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderTaskList(value);
	}

	public static List<OrderTaskList> fromValues(List<GenericValue> values) {
		List<OrderTaskList> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderTaskList(value));
		}
		return entities;
	}
}