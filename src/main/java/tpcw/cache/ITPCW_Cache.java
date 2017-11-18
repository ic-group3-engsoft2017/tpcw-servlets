package tpcw.cache;

import java.util.Optional;


public interface ITPCW_Cache {
	public void add(CachableEntity entity);
	public Optional<CachableEntity> getById(Class<?> objClass, Integer id);
}
