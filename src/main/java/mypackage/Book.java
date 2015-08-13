package mypackage;


import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "isbn")
    private String ISBN;
    public Book(String name, String ISBN){

        this.name = name;
        this.ISBN = ISBN;
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
