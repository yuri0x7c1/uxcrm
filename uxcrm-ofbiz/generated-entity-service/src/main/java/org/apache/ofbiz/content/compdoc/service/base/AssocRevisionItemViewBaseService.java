package org.apache.ofbiz.content.compdoc.service.base;

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
import org.apache.ofbiz.content.compdoc.AssocRevisionItemView;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AssocRevisionItemViewBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AssocRevisionItemViewBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AssocRevisionItemViews
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AssocRevisionItemView.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AssocRevisionItemViews
	 */
	public List<AssocRevisionItemView> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AssocRevisionItemView> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AssocRevisionItemView.NAME);
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
				entityList = AssocRevisionItemView.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AssocRevisionItemView
	 */
	public Optional<AssocRevisionItemView> findOne(Object contentId,
			Object contentIdTo, Object contentAssocTypeId, Object fromDate,
			Object rootRevisionContentId, Object itemContentId,
			Object contentRevisionSeqId, Object maxRevisionSeqId) {
		List<AssocRevisionItemView> entityList = null;
		In in = new In();
		in.setEntityName(AssocRevisionItemView.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentId", EntityOperator.EQUALS, contentId),
				new EntityExpr("contentIdTo", EntityOperator.EQUALS,
						contentIdTo), new EntityExpr("contentAssocTypeId",
						EntityOperator.EQUALS, contentAssocTypeId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate),
				new EntityExpr("rootRevisionContentId", EntityOperator.EQUALS,
						rootRevisionContentId), new EntityExpr("itemContentId",
						EntityOperator.EQUALS, itemContentId), new EntityExpr(
						"contentRevisionSeqId", EntityOperator.EQUALS,
						contentRevisionSeqId), new EntityExpr(
						"maxRevisionSeqId", EntityOperator.EQUALS,
						maxRevisionSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AssocRevisionItemView.fromValues(out.getListIt()
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
}