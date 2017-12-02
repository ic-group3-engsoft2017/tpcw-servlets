package tpcw.group3.model;

/**
 * The type Entity.
 *
 * @param <T> the type parameter
 */
public abstract class Entity<T> {

	private T id;
    public abstract int hashCode();
    public abstract boolean equals(Object e);

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(T id) {
		this.id = id;
	}

    /**
     * Gets id.
     *
     * @return the id
     */
    public T getId() {
		return id;
	}
}
