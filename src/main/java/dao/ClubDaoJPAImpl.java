package dao;

import hibernate.HibernateConnector;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Club;
import models.NationalTeam;
import models.Player;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ClubDaoJPAImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Club> findByName(String name) {
        this.entityManager = HibernateConnector.getConnector().getManager();

        entityManager.getTransaction().begin();

        return this.entityManager.createQuery("FROM Club club where club.name = :clubName", Club.class).setParameter("clubName", name).getResultList();
    }

    public void save(Club club) {
        this.entityManager = HibernateConnector.getConnector().getManager();

        entityManager.getTransaction().begin();

        entityManager.persist(club);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Club update(Club club) {
        this.entityManager = HibernateConnector.getConnector().getManager();

        entityManager.getTransaction().begin();

        return this.entityManager.merge(club);
    }

    public void delete(Club club) {
        this.entityManager = HibernateConnector.getConnector().getManager();

        entityManager.getTransaction().begin();

        entityManager.remove(club);
    }
}
