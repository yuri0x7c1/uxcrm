package org.apache.ofbiz.content.data.service.base;

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
import org.apache.ofbiz.content.data.MetaDataPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.content.ContentMetaData;
import org.apache.ofbiz.content.data.DataResourceMetaData;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class MetaDataPredicateBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public MetaDataPredicateBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count MetaDataPredicates
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(MetaDataPredicate.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find MetaDataPredicates
	 */
	public List<MetaDataPredicate> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<MetaDataPredicate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MetaDataPredicate.NAME);
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
				entityList = MetaDataPredicate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one MetaDataPredicate
	 */
	public Optional<MetaDataPredicate> findOne(Object metaDataPredicateId) {
		List<MetaDataPredicate> entityList = null;
		In in = new In();
		in.setEntityName(MetaDataPredicate.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("metaDataPredicateId",
						EntityOperator.EQUALS, metaDataPredicateId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MetaDataPredicate.fromValues(out.getListIt()
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
	 * Get content meta datas
	 */
	public List<ContentMetaData> getContentMetaDatas(
			MetaDataPredicate metaDataPredicate, Integer start, Integer number,
			List<String> orderBy) {
		List<ContentMetaData> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentMetaData.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("metaDataPredicateId",
						EntityOperator.EQUALS, metaDataPredicate
								.getMetaDataPredicateId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentMetaData.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get data resource meta datas
	 */
	public List<DataResourceMetaData> getDataResourceMetaDatas(
			MetaDataPredicate metaDataPredicate, Integer start, Integer number,
			List<String> orderBy) {
		List<DataResourceMetaData> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(DataResourceMetaData.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("metaDataPredicateId",
						EntityOperator.EQUALS, metaDataPredicate
								.getMetaDataPredicateId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = DataResourceMetaData.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}