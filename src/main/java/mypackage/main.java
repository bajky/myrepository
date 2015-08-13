package mypackage;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

class App {

    public static void main(String[] args) {

        Book book1 = new Book("firs", "a");
        Book book2 = new Book("second", "b");
        Book book3 = new Book("last", "c");

        System.out.println(" =======CREATE =======");


        create(book1);
        create(book2);
        create(book3);
    }
        public static Integer create(Book e){
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully created " + e.toString());

            return e.getId();
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
