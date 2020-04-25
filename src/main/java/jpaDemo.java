import javax.persistence.*;

public class jpaDemo {
//    web项目中一般通过注解注入
    @PersistenceContext
    private EntityManager entityManager;
    public static void main(String[] args) {
//        J2SE一般通过persistence.xml获取
//        需要注意的是persistence.xml的位置必须是classpath:/META-INF/persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(new User(0,"fcy","fcy"));
        transaction.commit();
        entityManager.close();
        emf.close();
    }
}
