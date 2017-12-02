package tpcw.group3.cache.service;

import java.util.Optional;

import tpcw.group3.cache.model.CachableEntity;


/**
 * The interface Itpcw cache.
 */
public interface ITPCW_Cache {
    /**
     * Add.
     *
     * @param entity the entity
     */
    void add(CachableEntity entity);

    /**
     * Gets by id.
     *
     * @param objClass the obj class
     * @param id       the id
     * @return the by id
     */
    Optional<CachableEntity> getById(Class<?> objClass, Integer id);
}
