package fr.simplon;

import java.util.List;

import fr.simplon.model.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("connect");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println("----------- Lecture de tous les articles -----------");

            List<Article> articles = entityManager.createQuery("from Article", Article.class).getResultList();

            for (Article article : articles) {
                System.out.println(article);
            }

            System.out.println("- Insertion d'un nouvel article ----------");

            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();

            Article newArticle = new Article("DBS", "Aston Martin", 200000.0);
            entityManager.persist(newArticle); // permet de valider l'enregistrment en BD

            List<Article> results = entityManager.createQuery("from Article",
                    Article.class).getResultList();

            for (Article article : results) {
                System.out.println(article);
            }

            System.out.println("- Modification d'un article --------------");

            newArticle.setPrice(226789.0);
            entityManager.persist(newArticle);

            results = entityManager.createQuery("from Article",
                    Article.class).getResultList();
            for (Article article : results) {
                System.out.println(article);
            }

            System.out.println("- Suppression d'un article ---------------");

            entityManager.remove(newArticle);

            results = entityManager.createQuery("from Article",
                    Article.class).getResultList();
            for (Article article : results) {
                System.out.println(article);
            }

            trans.commit();

        } finally {
            if (entityManager != null)
                entityManager.close();
            if (entityManagerFactory != null)
                entityManagerFactory.close();
        }
    }
}
