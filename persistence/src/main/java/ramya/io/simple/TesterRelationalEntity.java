package ramya.io.simple;


import ramya.io.simple.entity.Address;
import ramya.io.simple.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesterRelationalEntity {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        //INSERT
//        User user = new User();
//        user.setEmail("sri@gmail.com");
//        user.setFirstName("Sri");
//        user.setLastName("ramya");
//
//        Address address = new Address();
//        address.setCity("Fresno");
//        address.setState("California");
//        address.setStreet("Backer");
//
//
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(address);
//        user.setAddress(address);
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();


        // FIND
//        User user = entityManager.find(User.class, "a4ae6dbc-dd15-4b6a-8ffc-26ef331b66c8");
//        System.out.println(user);


        entityManager.close();
        entityManagerFactory.close();
    }
}
