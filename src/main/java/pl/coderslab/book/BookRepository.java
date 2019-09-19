package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.author.Author;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookDaoD4 {
    ////////////////////////w ostatnim zadaniu dodan BookDaoD4////////////////

    List<Book> findByRatingGreaterThan(int rating);

    List<Book> findByPropositionTrue();





    ////zadanie 2////

    List<Book> findByTitle(String title);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsId(Long authorId);
    ////działa bo działa przez encje///////////


    List<Book> findByPublisherId(Long publisheId);
    //niedociągnięte bo proste...//////////


    List<Book> findByRating(int rating);
    /////niedociągnięte/////


    Book findFirstByCategoryIdOrderByTitleAsc(Long categoryId);




    ////////4 dzien 2 czesc zadan/////////////
    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleQuery(String title);

    @Query("select b from Book b where b.category.id = :categoryId")
    List<Book> findByCategoryIdQuery(@Param("categoryId") Long categoryId);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findByRatingBetween(Integer num1, Integer num2);

    @Query("select b from Book b where b.publisher.id = ?1")
    List<Book> findByPublisherIdQuery(Long publisheId);

    //musie byc natywny sql bo nie ciezko z JPQL
    @Query(value = "select * from books where category_id = ?1 order by title limit 1", nativeQuery = true)
    Book findFirstByCategoryIdOrderByTitleQuery(Long categoryId);

















}