package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import vo.Event;

import java.util.List;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
public interface SpringJpa extends JpaRepository<Event, Long> {

    List<Event> findByName(String name);

}
