package tpcw.group3.cache.model.criteria;

public class BookCriteria extends Criteria<Integer> {

	private String subject;
	private String authorFirstName;
	private String authorLastName;
	private String title;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BookCriteria)) return false;

		BookCriteria that = (BookCriteria) o;

		if (getSubject() != null ? !getSubject().equals(that.getSubject()) : that.getSubject() != null) return false;
		if (getAuthorFirstName() != null ? !getAuthorFirstName().equals(that.getAuthorFirstName()) : that.getAuthorFirstName() != null)
			return false;
		if (getAuthorLastName() != null ? !getAuthorLastName().equals(that.getAuthorLastName()) : that.getAuthorLastName() != null)
			return false;
		return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
	}

	@Override
	public int hashCode() {
		int result = getSubject() != null ? getSubject().hashCode() : 0;
		result = 31 * result + (getAuthorFirstName() != null ? getAuthorFirstName().hashCode() : 0);
		result = 31 * result + (getAuthorLastName() != null ? getAuthorLastName().hashCode() : 0);
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		return result;
	}
}
