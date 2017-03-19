package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jieniyimiao on 2017/3/18.
 */
@Aspect
public class MockAspect {

    @Pointcut("execution(* hello.MessagePrinter.printMessage(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before.");

        //获取方法名
        String method = joinPoint.getSignature().getName();
        //获取参数
        String args = Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", "));
        //获取target，也就是所属的类
        Object target = joinPoint.getTarget();
        System.out.println("在"+target+"上调用"+method+"参数:"+args);
    }

    @After("pointcut()")
    public void after() {
        System.out.println("After.");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getTarget());

        System.out.println("Around 1.");
        Object obj = pjp.proceed();
        System.out.println("Around 2.");
        System.out.println("Around : " + obj);
        return obj;
    }

}