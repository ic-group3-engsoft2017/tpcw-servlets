package tpcw.model;

public abstract class Entity<T> {

	private T id;
    public abstract int hashCode();
    public abstract boolean equals(Object e);
    
    public void setId(T id) {
		this.id = id;
	}

    public T getId() {
		return id;
	}
}
