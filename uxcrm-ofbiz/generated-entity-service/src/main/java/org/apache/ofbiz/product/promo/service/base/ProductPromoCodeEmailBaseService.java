package org.apache.ofbiz.product.promo.service.base;

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
import org.apache.ofbiz.product.promo.ProductPromoCodeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.promo.ProductPromoCode;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPromoCodeEmailBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPromoCodeEmailBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPromoCodeEmails
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPromoCodeEmail.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPromoCodeEmails
	 */
	public List<ProductPromoCodeEmail> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductPromoCodeEmail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCodeEmail.NAME);
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
				entityList = ProductPromoCodeEmail.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductPromoCodeEmail
	 */
	public Optional<ProductPromoCodeEmail> findOne(Object productPromoCodeId,
			Object emailAddress) {
		List<ProductPromoCodeEmail> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoCodeEmail.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoCodeId", EntityOperator.EQUALS,
						productPromoCodeId), new EntityExpr("emailAddress",
						EntityOperator.EQUALS, emailAddress)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCodeEmail.fromValues(out.getListIt()
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
	 * Get product promo code
	 */
	public Optional<ProductPromoCode> getProductPromoCode(
			ProductPromoCodeEmail productPromoCodeEmail) {
		List<ProductPromoCode> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoCode.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoCodeId",
						EntityOperator.EQUALS, productPromoCodeEmail
								.getProductPromoCodeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCode.fromValues(out.getListIt()
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