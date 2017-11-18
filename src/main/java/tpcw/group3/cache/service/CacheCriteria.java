package tpcw.group3.cache.service;

import java.util.List;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.Criteria;

public interface CacheCriteria {
	public void add(Criteria<Integer> criteria, CachableEntity entity);
	public List<CachableEntity> getByCriteria(Criteria<Integer> criteria, CachableEntity entity);

}
