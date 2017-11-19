package tpcw.group3.cache.service;

import org.junit.Test;
import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.BookCriteria;
import tpcw.group3.cache.model.criteria.builder.BookCriteriaBuilder;
import tpcw.group3.model.Book;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static tpcw.group3.cache.model.criteria.builder.BookCriteriaBuilder.builder;

public class BookCacheCriteriaServiceTest {

    BookCacheCriteriaService service = new BookCacheCriteriaService();

    @Test
    public void whenAddAItemToANonFullBufferItMustAddForLaterFastFetch() throws Exception {
        BookCriteria bookCriteria = builder().withAuthorLastName("Tzu")
                                    .withAuthorFirstName("Sun").withTitle("Art of War").build();
        List<CachableEntity> knownBooksOfSunTzu = Collections.singletonList(mockSunTzuArtOfWar());
        service.add(bookCriteria, knownBooksOfSunTzu);

        assertEquals(knownBooksOfSunTzu, service.getByCriteria(bookCriteria));
    }

    @Test
    public void whenNotAItemInBufferServiceShouldReturnEmptyList() throws Exception {
        BookCriteria bookCriteria = builder().withAuthorLastName("Tzu")
                .withAuthorFirstName("Sun").withTitle("Art of War").build();
        List<CachableEntity> knownBooksOfSunTzu = Collections.singletonList(mockSunTzuArtOfWar());

        assertNotEquals(knownBooksOfSunTzu, service.getByCriteria(bookCriteria));
        assertEquals(Collections.emptyList(), service.getByCriteria(bookCriteria));
    }


    private Book mockSunTzuArtOfWar() {
        return new Book(1, "Art of War", "Sun", "Tzu");
    }
}