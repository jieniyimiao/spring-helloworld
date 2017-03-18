package hello;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vo.Event;

import java.util.List;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
public class SpringJpaTest extends  BaseTest {

    @Autowired
    SpringJpa springJpa;

    @Test
    public void springJpaTest() {
        List<Event> list = springJpa.findAll();
        for (Event e : list) {
            System.out.println(e);
        }
    }

    @Test
    public void findTest() {
        List<Event> list = springJpa.findByName("jack");
        for (Event e : list) {
            System.out.println(e);
        }
    }

}
