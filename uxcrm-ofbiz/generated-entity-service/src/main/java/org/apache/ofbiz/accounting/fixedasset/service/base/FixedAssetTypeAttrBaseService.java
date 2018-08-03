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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetType;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetAttribute;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetTypeAttrBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetTypeAttrs
	 */
	public List<FixedAssetTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetTypeAttr.NAME);
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
				entityList = FixedAssetTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetTypeAttr
	 */
	public Optional<FixedAssetTypeAttr> findOne(Object fixedAssetTypeId,
			Object attrName) {
		List<FixedAssetTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetTypeId", EntityOperator.EQUALS,
						fixedAssetTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetTypeAttr.fromValues(out.getListIt()
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
	 * Get fixed asset type
	 */
	public Optional<FixedAssetType> getFixedAssetType(
			FixedAssetTypeAttr fixedAssetTypeAttr) {
		List<FixedAssetType> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetTypeId",
						EntityOperator.EQUALS, fixedAssetTypeAttr
								.getFixedAssetTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetType.fromValues(out.getListIt()
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
	 * Get fixed asset attributes
	 */
	public List<FixedAssetAttribute> getFixedAssetAttributes(
			FixedAssetTypeAttr fixedAssetTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<FixedAssetAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						fixedAssetTypeAttr.getAttrName())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed assets
	 */
	public List<FixedAsset> getFixedAssets(
			FixedAssetTypeAttr fixedAssetTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<FixedAsset> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetTypeId",
						EntityOperator.EQUALS, fixedAssetTypeAttr
								.getFixedAssetTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}