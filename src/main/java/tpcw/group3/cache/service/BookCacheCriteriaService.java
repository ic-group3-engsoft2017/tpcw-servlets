package tpcw.group3.cache.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.Criteria;
import tpcw.group3.model.Book;

public class BookCacheCriteriaService implements CacheCriteria {

	private static BookCacheCriteriaService service;

	public static BookCacheCriteriaService getInstance() {
		if (service == null) {
			service = new BookCacheCriteriaService();
		}
		return service;
	}

    private Map<Criteria<Integer>, TreeSet<CachableEntity>> cacheMap;
    private final int CACHE_BUFFER = 50;
    
    public BookCacheCriteriaService() {
    	cacheMap = new HashMap<>();
    }

	@Override
	public void add(Criteria<Integer> criteria, CachableEntity entity) {
		TreeSet<CachableEntity> cachables;
		if (cacheMap.containsKey(criteria)) {
			cachables = cacheMap.get(criteria);
			applyPolice(cachables);
		} else {
			cachables = createNewSet();			
		}
		cache(criteria, entity, cachables);
	}
	
	@Override
	public List<CachableEntity> getByCriteria(Criteria<Integer> criteria, CachableEntity entity) {
		TreeSet<CachableEntity> cachables;
		if (cacheMap.containsKey(criteria)) {
			cachables = cacheMap.get(criteria);		
		}
		return Collections.emptyList();
	}

	private void cache(Criteria<Integer> criteria,  CachableEntity entity, TreeSet<CachableEntity> cachables) {
		entity.addHit();
		cachables.add(entity);
		cacheMap.put(criteria, cachables);
	}

	private void applyPolice(TreeSet<CachableEntity> cachables) {
		if (cachables.size() >= CACHE_BUFFER) {
			CachableEntity last = cachables.last();
			cachables.remove(last);
		}
	}
	
	private TreeSet<CachableEntity> createNewSet() {
		return new TreeSet<>(Comparator.comparingInt(CachableEntity::getNumberOfHits).reversed());
	}	
	
	public Optional<CachableEntity> findBookByAuthor(String authorName, String authorLastName) {
		TreeSet<CachableEntity> bookCache = cacheMap.get(Book.class);
		return bookCache.stream().filter(book -> findByExample(book, authorName, authorLastName)).findFirst();
	}

	private boolean findByExample(CachableEntity cachableEntity, String authorName, String authorLastName) {
		return authorName.equals(((Book) cachableEntity).a_fname) || authorLastName.equals(((Book)cachableEntity).a_lname);
	}
	
}
