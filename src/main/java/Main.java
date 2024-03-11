import entity.Auto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto[] auta = new Auto[] {new Auto("Volkswagen", "Golf", "ZA364AX"),
        new Auto("Skoda", "Fabia", "KM557OL"), new Auto("OPEL", "ASTRA", "LM254BC")};

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        for (Auto auto : auta) {
            em.persist(auto);
        }
        em.getTransaction().commit();
        List<Auto> autaList = em.createQuery("SELECT a FROM Auto a", Auto.class).getResultList();
        System.out.println("Vsetky Auta");
        vypisAuta(autaList);
        System.out.println("Auta v ZA OKRESE");
        List<Auto> autaList2 = em.createQuery("SELECT a FROM Auto a WHERE a.spz LIKE 'ZA%'", Auto.class).getResultList();
        vypisAuta(autaList2);
        em.close();
        entityManagerFactory.close();
    }

    private static void vypisAuta(List<Auto> autaList) {
        for (Auto auto : autaList) {
            System.out.println(auto);
        }
    }
}
