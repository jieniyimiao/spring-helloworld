package hello;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
@Aspect
public class MockAspect {

    @Pointcut("execution(* hello.MessagePrinter.printMessage(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        System.out.println("Before.");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("After.");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around 1.");
        Object obj = pjp.proceed();
        System.out.println("Around 2.");
        System.out.println("Around : " + obj);
        return obj;
    }

}