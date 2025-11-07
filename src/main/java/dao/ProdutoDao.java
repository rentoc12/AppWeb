package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Produto;
import java.util.List;

public class ProdutoDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("appProdutosPU");

    public void salvar(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Produto> listar() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Produto", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }
}
