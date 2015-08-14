package mypackage;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_isbn")
    private String ISBN;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;


    public Book(String name, String ISBN, Library library){

        this.name = name;
        this.ISBN = ISBN;
        this.library = library;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString(){
        return this.id + this.name + this.ISBN;
    }
}
