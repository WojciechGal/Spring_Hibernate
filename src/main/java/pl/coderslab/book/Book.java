package pl.coderslab.book;

import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.validation.BookValidationGroup;
import pl.coderslab.validation.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    //encja musi miec konstruktor bezparametrowy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    //////////GRUPY WALIDACJI///////////
    private boolean proposition = false;













    @NotNull(groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    @Size(min = 5, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String title;



    //przewodnia strona to ta bez mapped by
    //i chyba raczej przewodnia powinna mieć jointable...
    //tu wszystkie relacje robilismy dwukierounkowo
    @NotEmpty(groups = BookValidationGroup.class) //bo od razu jest tworzona nowa lista
    @ManyToMany//(fetch = FetchType.EAGER) //tu np mozna dopisać kaskade i fetch
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @Range(min = 1, max = 10, groups = BookValidationGroup.class)
    private int rating;




    //zadziała bo stworzy sobie tez publishera dzięki kaskadzie, nie trzeba w book controller zapisać wydawcy
    //@ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(groups = BookValidationGroup.class)
    @ManyToOne
    private Publisher publisher;




    @NotEmpty(groups = PropositionValidationGroup.class)
    @Size(max = 600, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String description;


    @Min(value = 2, groups = BookValidationGroup.class)
    private int pages;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                '}';
    }








    ///////////4 dzień!!!///////////////

    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
