package ramya.io.simple;


import ramya.io.simple.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Tester {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //INSERT

       /* Employee emp = new Employee();
        emp.setEmail("sri@mail.net");
        emp.setFirstName("Its");
        emp.setLastName("me");

        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();*/

       //FIND BY ID

//      Employee emp = entityManager.find(Employee.class, "877662ba-c2c6-4384-b103-255481553aff");
//      System.out.println(emp);


        //UPDATE
//        Employee emp = entityManager.find(Employee.class, "877662ba-c2c6-4384-b103-255481553aff");
//        emp.setFirstName("JavaDeveloper");
//        entityManager.getTransaction().begin();
//        entityManager.merge(emp);
//        entityManager.getTransaction().commit();

        //DELETE
       /* Employee emp = entityManager.find(Employee.class, "d44a62d6-5ae0-48d4-8a05-5d07758456d1");

        entityManager.getTransaction().begin();
        entityManager.remove(emp);
        entityManager.getTransaction().commit();*/

       //FINDALL

//        TypedQuery<Employee> query = entityManager.createQuery( "SELECT emp FROM Employee emp ORDER BY emp.email DESC", Employee.class);
//        List<Employee> resultList = query.getResultList();
//        for(Employee emp: resultList){
//            System.out.println(emp);
//        }

        //FIND BY EMAIL

        TypedQuery<Employee>  query = entityManager.createNamedQuery("Employee.findByEmail", Employee.class);
        query.setParameter( "paramEmail", "ramya@gmail.com");
        List<Employee> resultList = query.getResultList();
        for(Employee emp : resultList){
            System.out.println(emp);
        }
        entityManager.close();
        entityManagerFactory.close();



    }
}
