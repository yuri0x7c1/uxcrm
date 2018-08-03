package org.apache.ofbiz.accounting.fixedasset.service.base;

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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetIdentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetIdent;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetIdentTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetIdentTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetIdentTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetIdentType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetIdentTypes
	 */
	public List<FixedAssetIdentType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetIdentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetIdentType.NAME);
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
				entityList = FixedAssetIdentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetIdentType
	 */
	public Optional<FixedAssetIdentType> findOne(Object fixedAssetIdentTypeId) {
		List<FixedAssetIdentType> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetIdentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetIdentTypeId",
						EntityOperator.EQUALS, fixedAssetIdentTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetIdentType.fromValues(out.getListIt()
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
	 * Get fixed asset idents
	 */
	public List<FixedAssetIdent> getFixedAssetIdents(
			FixedAssetIdentType fixedAssetIdentType, Integer start,
			Integer number, List<String> orderBy) {
		List<FixedAssetIdent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetIdent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetIdentTypeId",
						EntityOperator.EQUALS, fixedAssetIdentType
								.getFixedAssetIdentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetIdent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}