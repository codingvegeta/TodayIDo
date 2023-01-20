package jpabook.jpashop;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {


        } catch (Exception e) {

        }finally {
            em.close();
        }
            emf.close();
    }
}
