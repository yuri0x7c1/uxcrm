package org.apache.ofbiz.content.content.service.base;

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
import org.apache.ofbiz.content.content.ContentAssocOptViewFrom;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ContentAssocOptViewFromBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ContentAssocOptViewFromBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ContentAssocOptViewFroms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ContentAssocOptViewFrom.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ContentAssocOptViewFroms
	 */
	public List<ContentAssocOptViewFrom> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ContentAssocOptViewFrom> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ContentAssocOptViewFrom.NAME);
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
				entityList = ContentAssocOptViewFrom.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ContentAssocOptViewFrom
	 */
	public Optional<ContentAssocOptViewFrom> findOne(Object contentIdStart,
			Object contentId, Object caContentIdTo, Object caContentId,
			Object caFromDate, Object caContentAssocTypeId) {
		List<ContentAssocOptViewFrom> entityList = null;
		In in = new In();
		in.setEntityName(ContentAssocOptViewFrom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("contentIdStart", EntityOperator.EQUALS,
						contentIdStart), new EntityExpr("contentId",
						EntityOperator.EQUALS, contentId), new EntityExpr(
						"caContentIdTo", EntityOperator.EQUALS, caContentIdTo),
				new EntityExpr("caContentId", EntityOperator.EQUALS,
						caContentId), new EntityExpr("caFromDate",
						EntityOperator.EQUALS, caFromDate), new EntityExpr(
						"caContentAssocTypeId", EntityOperator.EQUALS,
						caContentAssocTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContentAssocOptViewFrom.fromValues(out.getListIt()
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