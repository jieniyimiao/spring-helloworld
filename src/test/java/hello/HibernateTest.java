package hello;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import vo.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
//spring test 自动回滚
@Transactional
public class HibernateTest extends BaseTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Rollback(false)
    public void insertTest() {

        Event event = new Event();
        event.setName("jack");
        entityManager.persist(event);
    }

    @Test
    public void getTest() {
        Event event = entityManager.find(Event.class, 1L);
        System.out.println(event);
    }

}
