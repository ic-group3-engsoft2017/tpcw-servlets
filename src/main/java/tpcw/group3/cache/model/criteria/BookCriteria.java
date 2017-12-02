package tpcw.group3.cache.model.criteria;

/**
 * The type Book criteria.
 */
public class BookCriteria extends Criteria {

	private String subject;
	private String authorFirstName;
	private String authorLastName;
	private String title;

	/**
	 * Gets subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets subject.
	 *
	 * @param subject the subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets author first name.
	 *
	 * @return the author first name
	 */
	public String getAuthorFirstName() {
		return authorFirstName;
	}

	/**
	 * Sets author first name.
	 *
	 * @param authorFirstName the author first name
	 */
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	/**
	 * Gets author last name.
	 *
	 * @return the author last name
	 */
	public String getAuthorLastName() {
		return authorLastName;
	}

	/**
	 * Sets author last name.
	 *
	 * @param authorLastName the author last name
	 */
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
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
