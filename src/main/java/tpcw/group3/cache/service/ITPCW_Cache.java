package tpcw.group3.cache.service;

import java.util.Optional;

import tpcw.group3.cache.model.CachableEntity;


public interface ITPCW_Cache {
	void add(CachableEntity entity);
	Optional<CachableEntity> getById(Class<?> objClass, Integer id);
}
