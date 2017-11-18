package tpcw.group3.cache.model.criteria;

public class Criteria <T> {
	
	private T id;
    private String name;
    
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
