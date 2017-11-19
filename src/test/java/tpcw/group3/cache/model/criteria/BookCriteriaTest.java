package tpcw.group3.cache.model.criteria;

import org.junit.Test;
import tpcw.group3.cache.model.criteria.builder.BookCriteriaBuilder;

import static org.junit.Assert.*;

public class BookCriteriaTest {


    @Test
    public void whenSearchAHittedCriteriaThenReturnTrue() throws Exception {
        BookCriteria criteriaForUncleBob = BookCriteriaBuilder.builder().withAuthorFirstName("Robert").withAuthorLastName("Martin").build();
        criteriaForUncleBob.addHit();
        BookCriteria criteriaForSearch = BookCriteriaBuilder.builder().withAuthorFirstName("Robert").withAuthorLastName("Martin").build();
        assertEquals(criteriaForUncleBob, criteriaForSearch);
    }

    @Test
    public void whenSearchAWrongCriteriaThenReturnFalse() throws Exception {
        BookCriteria criteriaForUncleBob = BookCriteriaBuilder.builder().withAuthorFirstName("Robert").withAuthorLastName("Martin").build();
        criteriaForUncleBob.addHit();
        BookCriteria criteriaForSearch = BookCriteriaBuilder.builder().withAuthorFirstName("Bob").withAuthorLastName("Martin").build();
        assertNotEquals(criteriaForUncleBob, criteriaForSearch);
    }



}