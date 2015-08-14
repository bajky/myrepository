package mypackage;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bajky on 13.8.2015.
 */

@Entity
@Table(name = "Library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int library_id;

    @Column(name = "library_name")
    private String libraryName;

    @Column(name = "library_address ")
    private String libraryAddress;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Set<Book> books;

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library(String libraryName, String libraryAddress){
        this.libraryAddress = libraryAddress;
        this.libraryName = libraryName;
    }

}
