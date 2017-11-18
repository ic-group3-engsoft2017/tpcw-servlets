package tpcw.group3.cache.model;

import java.util.concurrent.atomic.AtomicInteger;

import tpcw.group3.model.Entity;

public class CachableEntity extends Entity<Integer> implements Cloneable {

	private AtomicInteger numberOfHits;
	
    public CachableEntity() {
    }
    
    public Integer getNumberOfHits() {
		return numberOfHits.get();
	}
    
    public void addHit() {
    	numberOfHits.incrementAndGet();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfHits == null) ? 0 : numberOfHits.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CachableEntity other = (CachableEntity) obj;
		if (numberOfHits == null) {
			if (other.numberOfHits != null)
				return false;
		} else if (!numberOfHits.equals(other.numberOfHits))
			return false;
		return true;
	}
    
}

