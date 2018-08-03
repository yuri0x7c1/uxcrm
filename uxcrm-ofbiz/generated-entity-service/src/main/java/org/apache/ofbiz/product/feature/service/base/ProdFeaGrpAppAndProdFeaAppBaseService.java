package org.apache.ofbiz.product.feature.service.base;

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
import org.apache.ofbiz.product.feature.ProdFeaGrpAppAndProdFeaApp;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProdFeaGrpAppAndProdFeaAppBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProdFeaGrpAppAndProdFeaAppBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProdFeaGrpAppAndProdFeaApps
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProdFeaGrpAppAndProdFeaApp.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProdFeaGrpAppAndProdFeaApps
	 */
	public List<ProdFeaGrpAppAndProdFeaApp> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProdFeaGrpAppAndProdFeaApp> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdFeaGrpAppAndProdFeaApp.NAME);
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
				entityList = ProdFeaGrpAppAndProdFeaApp.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProdFeaGrpAppAndProdFeaApp
	 */
	public Optional<ProdFeaGrpAppAndProdFeaApp> findOne(
			Object productFeatureGroupId, Object productFeatureId,
			Object groupFromDate, Object productId, Object fromDate) {
		List<ProdFeaGrpAppAndProdFeaApp> entityList = null;
		In in = new In();
		in.setEntityName(ProdFeaGrpAppAndProdFeaApp.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productFeatureGroupId", EntityOperator.EQUALS,
						productFeatureGroupId), new EntityExpr(
						"productFeatureId", EntityOperator.EQUALS,
						productFeatureId), new EntityExpr("groupFromDate",
						EntityOperator.EQUALS, groupFromDate), new EntityExpr(
						"productId", EntityOperator.EQUALS, productId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdFeaGrpAppAndProdFeaApp.fromValues(out
						.getListIt().getCompleteList());
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
}