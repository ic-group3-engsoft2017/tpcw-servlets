package tpcw.group3.cache.service;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.BookCriteria;
import tpcw.group3.cache.model.criteria.Criteria;

import java.util.List;

/**
 * The interface Cache criteria.
 */
public interface CacheCriteria {
    /**
     * Add.
     *
     * @param criteria the criteria
     * @param entities the entities
     */
    void add(Criteria criteria, List<CachableEntity> entities);

    /**
     * Gets by criteria.
     *
     * @param criteria the criteria
     * @return the by criteria
     */
    List<CachableEntity> getByCriteria(Criteria criteria);

}
