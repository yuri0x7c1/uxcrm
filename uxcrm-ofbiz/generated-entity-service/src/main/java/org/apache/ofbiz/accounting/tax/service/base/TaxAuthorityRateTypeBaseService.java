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
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TaxAuthorityRateTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TaxAuthorityRateTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TaxAuthorityRateTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TaxAuthorityRateType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TaxAuthorityRateTypes
	 */
	public List<TaxAuthorityRateType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TaxAuthorityRateType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityRateType.NAME);
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
				entityList = TaxAuthorityRateType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TaxAuthorityRateType
	 */
	public Optional<TaxAuthorityRateType> findOne(Object taxAuthorityRateTypeId) {
		List<TaxAuthorityRateType> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityRateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateTypeId",
						EntityOperator.EQUALS, taxAuthorityRateTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateType.fromValues(out.getListIt()
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
	 * Get tax authority rate products
	 */
	public List<TaxAuthorityRateProduct> getTaxAuthorityRateProducts(
			TaxAuthorityRateType taxAuthorityRateType, Integer start,
			Integer number, List<String> orderBy) {
		List<TaxAuthorityRateProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateTypeId",
						EntityOperator.EQUALS, taxAuthorityRateType
								.getTaxAuthorityRateTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}