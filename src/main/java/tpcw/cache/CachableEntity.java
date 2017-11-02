package tpcw.cache;

import tpcw.model.Entity;

import java.util.HashMap;
import java.util.Optional;

public class CachableEntity<T extends Entity> {

    private HashMap<Long,T> cacheMap;

    public CachableEntity() {
        cacheMap = new HashMap<>();
    }

    public Optional<T> getFromCache(Long id) {
        if(cacheMap.containsKey(id)) {
            return Optional.of(cacheMap.get(id));
        } else {
            return Optional.empty();
        }
    }

    public void addToCache(Long id, T entity) throws IllegalArgumentException {
        if(cacheMap.containsKey(id)) {
            throw new IllegalArgumentException("Could not add to cache cause entity of id " +
                    id +" is already there");
        }
        cacheMap.put(id, entity);
    }

    public void renewCache(Long id, T entity) {

    }
}

