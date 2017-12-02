package tpcw.group3.cache.model.criteria.builder;

import tpcw.group3.cache.model.criteria.BookCriteria;

/**
 * The type Book criteria builder.
 */
public class BookCriteriaBuilder {

    /**
     * Instantiates a new Book criteria builder.
     */
    public BookCriteriaBuilder() {
        bookCriteria = new BookCriteria();
    }

    /**
     * Builder book criteria builder.
     *
     * @return the book criteria builder
     */
    public static BookCriteriaBuilder builder() {
        return new BookCriteriaBuilder();
    }

    private BookCriteria bookCriteria;

    /**
     * Build book criteria.
     *
     * @return the book criteria
     */
    public BookCriteria build() {
        return bookCriteria;
    }

    /**
     * With subject book criteria builder.
     *
     * @param subject the subject
     * @return the book criteria builder
     */
    public BookCriteriaBuilder withSubject(String subject) {
        bookCriteria.setSubject(subject);
        return this;
    }

    /**
     * With author first name book criteria builder.
     *
     * @param authorFirstName the author first name
     * @return the book criteria builder
     */
    public BookCriteriaBuilder withAuthorFirstName(String authorFirstName) {
        bookCriteria.setAuthorFirstName(authorFirstName);
        return this;
    }

    /**
     * With author last name book criteria builder.
     *
     * @param authorLastName the author last name
     * @return the book criteria builder
     */
    public BookCriteriaBuilder withAuthorLastName(String authorLastName) {
        bookCriteria.setAuthorLastName(authorLastName);
        return this;
    }

    /**
     * With title book criteria builder.
     *
     * @param title the title
     * @return the book criteria builder
     */
    public BookCriteriaBuilder withTitle(String title) {
        bookCriteria.setTitle(title);
        return this;
    }


}
