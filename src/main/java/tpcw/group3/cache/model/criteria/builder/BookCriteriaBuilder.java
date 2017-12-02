package tpcw.group3.cache.model.criteria.builder;

import tpcw.group3.cache.model.criteria.BookCriteria;

public class BookCriteriaBuilder {

    public BookCriteriaBuilder() {
        bookCriteria = new BookCriteria();
    }

    public static BookCriteriaBuilder builder() {
        return new BookCriteriaBuilder();
    }

    private BookCriteria bookCriteria;

    public BookCriteria build() {
        return bookCriteria;
    }

    public BookCriteriaBuilder withSubject(String subject) {
        bookCriteria.setSubject(subject);
        return this;
    }

    public BookCriteriaBuilder withAuthorFirstName(String authorFirstName) {
        bookCriteria.setAuthorFirstName(authorFirstName);
        return this;
    }

    public BookCriteriaBuilder withAuthorLastName(String authorLastName) {
        bookCriteria.setAuthorLastName(authorLastName);
        return this;
    }
 
    public BookCriteriaBuilder withTitle(String title) {
        bookCriteria.setTitle(title);
        return this;
    }


}
