package tpcw.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

import tpcw.cache.CachableEntity;
import tpcw.cache.ITPCW_Cache;

public class CacheService implements ITPCW_Cache {

    private Map<Class<?>, TreeSet<CachableEntity>> cacheMap;
    private final int CACHE_BUFFER = 50;
    
    public CacheService() {
    	cacheMap = new HashMap<>();
    }

	@Override
	public void add(CachableEntity entity) {
		TreeSet<CachableEntity> cachables;
		if (cacheMap.containsKey(entity.getClass())) {
			cachables = cacheMap.get(entity.getClass());
			applyPolice(cachables);
		} else {
			cachables = createNewSet();			
		}
		cache(cachables, entity);
	}

	private void cache(TreeSet<CachableEntity> cachables, CachableEntity entity) {
		entity.addHit();
		cachables.add(entity);
		cacheMap.put(entity.getClass(), cachables);
	}

	private void applyPolice(TreeSet<CachableEntity> cachables) {
		if (cachables.size() >= CACHE_BUFFER) {
			CachableEntity last = cachables.last();
			cachables.remove(last);
		}
	}

	@Override
	public Optional<CachableEntity> getById(Class<?> objClass, Integer id) {
		TreeSet<CachableEntity> cachables;
		if (cacheMap.containsKey(objClass)) {
			cachables = cacheMap.get(objClass);		
			for (CachableEntity cachable : cachables) {
				if (cachable.getId() == id) {
					return Optional.of(cachable);
				}
			}
		}
		return Optional.empty();
	}
	
	private TreeSet<CachableEntity> createNewSet() {
		return new TreeSet<>(Comparator.comparingInt(CachableEntity::getNumberOfHits).reversed());
	}
}
