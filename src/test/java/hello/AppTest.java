package hello;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
public class AppTest extends BaseTest
{
    @Autowired
    MessagePrinter messagePrinter;

    @Test
    public void printerMessageTest() {
        messagePrinter.printMessage();
    }

    @Test
    public void getEnvTest() {
        String name = getEnv().getProperty("name");
        String age = getEnv().getProperty("age");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }

}
