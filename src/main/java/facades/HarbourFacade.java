package facades;

import dto.HarbourDTO;
import entities.Harbour;
import entities.User;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HarbourFacade {
        private static EntityManagerFactory emf;
        private static facades.HarbourFacade instance;

        private HarbourFacade() {
        }
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static HarbourFacade getHarbourFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HarbourFacade();
        }
        return instance;
    }
    public Harbour createHarbour(Harbour harbour){
            EntityManager em = getEntityManager();
            try {
            em.getTransaction().begin();
            em.persist(harbour);
            em.getTransaction().commit();
            }finally {
                em.close();
            }
    return harbour;
    }
    public List<HarbourDTO> getAllHarbours() throws NotFoundException {
            EntityManager em = getEntityManager();
            try {
                TypedQuery<Harbour> query = em.createQuery("SELECT h FROM Harbour h", Harbour.class);
                if (query == null) {
                    throw new NotFoundException("No harbour");
                }
                List<Harbour> harbourList = query.getResultList();
                return HarbourDTO.getHarbourDTOs(harbourList);
            }finally {
                em.close();
            }
    }
}
