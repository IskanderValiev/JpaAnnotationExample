package hibernate;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnector {
    private static HibernateConnector connector;
    private EntityManagerFactory factory;

    private HibernateConnector() {
        factory = Persistence.createEntityManagerFactory("Idea_JPA");
    }

    static {
        connector = new HibernateConnector();
    }

    public static HibernateConnector getConnector() {
        return connector;
    }

    public EntityManager getManager() throws HibernateException {
        EntityManager manager = factory.createEntityManager();
        if (!manager.isOpen()) {
            this.reconnect();
        }
        return manager;
    }

    private void reconnect() throws HibernateException {
        factory = Persistence.createEntityManagerFactory("Idea_JPA");
    }
}