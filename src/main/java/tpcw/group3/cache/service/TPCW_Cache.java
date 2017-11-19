package tpcw.group3.cache.service;

import java.util.*;


import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.model.Book;


public class TPCW_Cache implements ITPCW_Cache {

	private static TPCW_Cache singleton;

	public static TPCW_Cache getInstance() {
		if (singleton == null) {
			singleton = new TPCW_Cache();
		}
		return singleton;
	}

    private Map<Class<?>, TreeSet<CachableEntity>> cacheMap;
    private final int CACHE_BUFFER = 50;

    public TPCW_Cache() {
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
					cachable.addHit();
					return Optional.of(cachable);
				}
			}
		}
		return Optional.empty();
	}
	
	private TreeSet<CachableEntity> createNewSet() {
		return new TreeSet<>(Comparator.comparingInt(CachableEntity::getNumberOfHits).reversed());
	}	
	
	public Optional<CachableEntity> findBookByAuthor(String authorName, String authorLastName) {
		TreeSet<CachableEntity> bookCache = cacheMap.get(Book.class);
		return bookCache.stream().filter(book -> findByExample(book, authorName, authorLastName)).findFirst();
	}

    private List<CachableEntity> findByFilter(CachableEntity cachableEntity, String authorName, String authorLastName) {
        return null;
    }

	private boolean findByExample(CachableEntity cachableEntity, String authorName, String authorLastName) {
		return authorName.equals(((Book) cachableEntity).a_fname) || authorLastName.equals(((Book)cachableEntity).a_lname);
	}
}
