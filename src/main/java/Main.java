import entity.Auto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
        em.close();
        entityManagerFactory.close();
    }
}
