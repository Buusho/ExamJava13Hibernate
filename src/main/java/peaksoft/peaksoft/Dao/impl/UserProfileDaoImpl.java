package peaksoft.peaksoft.Dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.peaksoft.Dao.UserProfileDao;
import peaksoft.peaksoft.Entity.UserProfile;
import peaksoft.peaksoft.config.HibernateConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserProfileDaoImpl implements UserProfileDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();

    @Override
    public String saveUserP(UserProfile userP) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userP);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully Saved !";
    }

    @Override
    public Optional<UserProfile> getUserPById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserProfile userProfile = null;
        try {
            entityManager.getTransaction().begin();
            userProfile = entityManager.find(UserProfile.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return Optional.ofNullable(userProfile);
    }

    @Override
    public String updateUserP(Long userPId, UserProfile newUserP) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update UserProfile u set u.user_name =:username , u.email =:eamil,u.registration_date =:registration where u.id =:id")
                    .setParameter("id", userPId)
                    .setParameter("username", newUserP.getUser_name())
                    .setParameter("eamil", newUserP.getEmail())
                    .setParameter("registration", newUserP.getRegistration_date())
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully updated !";
    }

    @Override
    public void deleteUserPById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, id);
            entityManager.remove(userProfile);
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void getUserPByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("select u from UserProfile u where u.email =:email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }

    }

    @Override
    public List<UserProfile> GetUserRegisteredAfterDate(LocalDate date) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<UserProfile> userProfiles = entityManager.createQuery("select u from UserProfile u where u.registration_date >:registration", UserProfile.class)
                    .getResultList();
            entityManager.getTransaction().commit();
            return userProfiles;
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return null ;
    }


    public void rollback(EntityManager entityManager) {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
        entityManager.close();
    }
}
