package tpcw.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import tpcw.cache.CachableEntity;
import tpcw.cache.ITPCW_Cache;
import tpcw.model.Entity;

public class CacheService implements ITPCW_Cache {

    private Map<Class<?>, TreeSet<CachableEntity<Entity>>> cacheMap;

	@Override
	public void add(Entity entity) {

	}

	@Override
	public Optional<Entity> getById(String clazz, Long id) {
		
		return null;
	}
    
    
    
	
}
