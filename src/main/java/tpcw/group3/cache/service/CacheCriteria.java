package tpcw.group3.cache.service;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.BookCriteria;
import tpcw.group3.cache.model.criteria.Criteria;

import java.util.List;

public interface CacheCriteria {
	void add(Criteria criteria, List<CachableEntity> entities);
	List<CachableEntity> getByCriteria(Criteria criteria);

}
