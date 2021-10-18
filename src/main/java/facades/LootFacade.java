package facades;

import dtos.LootDTO;
import entities.Loot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class LootFacade {

    private static LootFacade instance;
    private static EntityManagerFactory emf;


    private LootFacade() {
    }


    public static LootFacade getInstance(EntityManagerFactory _emf) {

        if (instance == null) {
            emf = _emf;
            instance = new LootFacade();
        }
        return instance;
    }


    public LootDTO addLoot(LootDTO lootDTO) {
        EntityManager em = emf.createEntityManager();
        Loot entityLoot = new Loot(lootDTO);
        try {
            em.getTransaction().begin();
            em.persist(entityLoot);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new LootDTO(entityLoot);
    }


    public LootDTO deleteLoot(Long id) {
        EntityManager em = emf.createEntityManager();
        Loot entityLoot = em.find(Loot.class,id);
        try {
            em.getTransaction().begin();
            em.remove(entityLoot);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new LootDTO(entityLoot);
    }

    public List<LootDTO> getAllLoot() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Loot> query = em.createQuery("SELECT L from Loot L", Loot.class);
            List<Loot> entityLoot = query.getResultList();
            return LootDTO.toDTOs(entityLoot);
        } finally {
            em.close();
        }
    }

    public List<LootDTO> getAllLootFromPlayer(String playerName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Loot> query = em.createQuery("SELECT L from Loot L WHERE l.playerName =:playerName", Loot.class);
            query.setParameter("playerName",playerName);
            List<Loot> entityLoot = query.getResultList();
            return LootDTO.toDTOs(entityLoot);
        } finally {
            em.close();
        }
    }

}
