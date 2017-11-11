package tpcw.cache;

import tpcw.model.Entity;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class CachableEntity<T extends Entity> {

	private AtomicInteger numberOfHits;
	
    public CachableEntity() {
    }
    
    public AtomicInteger getNumberOfHits() {
		return numberOfHits;
	}
    
    public void addHit() {
    	numberOfHits.incrementAndGet();
    }
    

//    public Optional<T> getFromCache(Long id) {
//        if(cacheMap.containsKey(id)) {
//            return Optional.of(cacheMap.get(id));
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    public void addToCache(Long id, T entity) throws IllegalArgumentException {
//        if(cacheMap.containsKey(id)) {
//            throw new IllegalArgumentException("Could not add to cache cause entity of id " +
//                    id +" is already there");
//        }
//        cacheMap.put(id, entity);
//    }
//
//    public void renewCache(Long id, T entity) {
//
//    }
}

