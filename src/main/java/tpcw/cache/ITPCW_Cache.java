package tpcw.cache;

import java.util.Optional;

import tpcw.model.Entity;

public interface ITPCW_Cache {
	public void add(CachableEntity entity);
	public Optional<CachableEntity> getById(Class<?> objClass, Integer id);
}
