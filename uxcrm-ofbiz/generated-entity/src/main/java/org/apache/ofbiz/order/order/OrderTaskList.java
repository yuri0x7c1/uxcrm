package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderTaskList implements Serializable {

	public static final long serialVersionUID = 2808114126440552448L;
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

	public OrderTaskList(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		orderRoleTypeId = (String) value.get(FIELD_ORDER_ROLE_TYPE_ID);
		customerPartyId = (String) value.get(FIELD_CUSTOMER_PARTY_ID);
		customerFirstName = (String) value.get(FIELD_CUSTOMER_FIRST_NAME);
		customerLastName = (String) value.get(FIELD_CUSTOMER_LAST_NAME);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		workEffortTypeId = (String) value.get(FIELD_WORK_EFFORT_TYPE_ID);
		currentStatusId = (String) value.get(FIELD_CURRENT_STATUS_ID);
		lastStatusUpdate = (Timestamp) value.get(FIELD_LAST_STATUS_UPDATE);
		priority = (Long) value.get(FIELD_PRIORITY);
		workEffortName = (String) value.get(FIELD_WORK_EFFORT_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		estimatedCompletionDate = (Timestamp) value
				.get(FIELD_ESTIMATED_COMPLETION_DATE);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		actualCompletionDate = (Timestamp) value
				.get(FIELD_ACTUAL_COMPLETION_DATE);
		infoUrl = (String) value.get(FIELD_INFO_URL);
		wepaPartyId = (String) value.get(FIELD_WEPA_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDateTime = (Timestamp) value.get(FIELD_STATUS_DATE_TIME);
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