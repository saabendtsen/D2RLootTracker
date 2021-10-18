package facades;


import dtos.LootDTO;
import entities.*;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LootFacadeTest {
    private Loot loot;
    private static EntityManagerFactory emf;
    private final LootFacade facade = LootFacade.getInstance(emf);

    public LootFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory();

    }

    @AfterAll
    public static void tearDownClass() {


    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            loot = new Loot("Elcap", new Date(), "tal armor", false, true);

            em.getTransaction().begin();
            em.persist(loot);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Loot.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

        @org.junit.jupiter.api.Test
    void addLoot() {
        List<LootDTO> allLootBefore = facade.getAllLoot();
        loot = new Loot("Elcap", new Date(), "IK armor", false, true);
        facade.addLoot(new LootDTO(loot));
        List<LootDTO> allLootAfter = facade.getAllLoot();
        assertEquals(allLootBefore.size() + 1, allLootAfter.size());

    }

    @org.junit.jupiter.api.Test
    void deleteLoot() {
        List<LootDTO> allLootBefore = facade.getAllLoot();
        List<LootDTO> allLoot = facade.getAllLoot();
        facade.deleteLoot(allLoot.get(0).getId());
        List<LootDTO> allLootAfter = facade.getAllLoot();
        assertEquals(allLootBefore.size() - 1, allLootAfter.size());
    }

    @org.junit.jupiter.api.Test
    void getAllLoot() {
        List<LootDTO> allLoot = facade.getAllLoot();

        assertTrue(allLoot.size() != 0);

    }

    @org.junit.jupiter.api.Test
    void getAllLootFromPlayer() {
        List<LootDTO> allLoot = facade.getAllLootFromPlayer("Elcap");
        assertTrue(allLoot.size() != 0);

        allLoot = facade.getAllLootFromPlayer("elcap");

        assertTrue(allLoot.size() != 0);


    }


}