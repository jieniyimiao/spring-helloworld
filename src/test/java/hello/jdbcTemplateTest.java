package hello;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
public class jdbcTemplateTest extends BaseTest{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void curdTest() {
        int count = jdbcTemplate.queryForObject(
                "select count(*) from stu", Integer.class);

        System.out.println(count);

        jdbcTemplate.update(
                "INSERT INTO STU VALUES (?, ?)", 11, "Bill Gates");
    }

}
