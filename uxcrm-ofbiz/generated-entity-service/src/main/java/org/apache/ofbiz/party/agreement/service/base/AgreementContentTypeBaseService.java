package org.apache.ofbiz.party.agreement.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.party.agreement.AgreementContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.agreement.AgreementContent;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AgreementContentTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AgreementContentTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AgreementContentTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AgreementContentType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AgreementContentTypes
	 */
	public List<AgreementContentType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AgreementContentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementContentType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AgreementContentType
	 */
	public Optional<AgreementContentType> findOne(Object agreementContentTypeId) {
		List<AgreementContentType> entityList = null;
		In in = new In();
		in.setEntityName(AgreementContentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementContentTypeId",
						EntityOperator.EQUALS, agreementContentTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContentType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get parent agreement content type
	 */
	public Optional<AgreementContentType> getParentAgreementContentType(
			AgreementContentType agreementContentType) {
		List<AgreementContentType> entityList = null;
		In in = new In();
		in.setEntityName(AgreementContentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementContentTypeId",
						EntityOperator.EQUALS, agreementContentType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContentType.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get agreement contents
	 */
	public List<AgreementContent> getAgreementContents(
			AgreementContentType agreementContentType, Integer start,
			Integer number, List<String> orderBy) {
		List<AgreementContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("agreementContentTypeId",
						EntityOperator.EQUALS, agreementContentType
								.getAgreementContentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child agreement content types
	 */
	public List<AgreementContentType> getChildAgreementContentTypes(
			AgreementContentType agreementContentType, Integer start,
			Integer number, List<String> orderBy) {
		List<AgreementContentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AgreementContentType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						agreementContentType.getAgreementContentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AgreementContentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}