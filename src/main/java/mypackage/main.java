package mypackage;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

class App {

    public static void main(String[] args) {
        Library library = new Library("aaaa","bbbb");

        library.setBooks(new HashSet<Book>());
        Book book1 = new Book("firs", "a",library);
        library.getBooks().add(book1);


        System.out.println(" =======CREATE =======");


        create(library);
    }
        public static Integer create(Library e){
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully created " + e.toString());

            return e.getLibrary_id();
        }

        public static SessionFactory getSessionFactory() {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(builder.build());
            return sessionFactory;
        }



}
