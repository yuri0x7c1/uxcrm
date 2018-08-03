package org.apache.ofbiz.accounting.tax.service.base;

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
import org.apache.ofbiz.accounting.tax.TaxAuthorityAssocType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.tax.TaxAuthorityAssoc;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TaxAuthorityAssocTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TaxAuthorityAssocTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TaxAuthorityAssocTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TaxAuthorityAssocType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TaxAuthorityAssocTypes
	 */
	public List<TaxAuthorityAssocType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TaxAuthorityAssocType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityAssocType.NAME);
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
				entityList = TaxAuthorityAssocType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TaxAuthorityAssocType
	 */
	public Optional<TaxAuthorityAssocType> findOne(
			Object taxAuthorityAssocTypeId) {
		List<TaxAuthorityAssocType> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityAssocTypeId",
						EntityOperator.EQUALS, taxAuthorityAssocTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssocType.fromValues(out.getListIt()
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
	 * Get tax authority assocs
	 */
	public List<TaxAuthorityAssoc> getTaxAuthorityAssocs(
			TaxAuthorityAssocType taxAuthorityAssocType, Integer start,
			Integer number, List<String> orderBy) {
		List<TaxAuthorityAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityAssocTypeId",
						EntityOperator.EQUALS, taxAuthorityAssocType
								.getTaxAuthorityAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}