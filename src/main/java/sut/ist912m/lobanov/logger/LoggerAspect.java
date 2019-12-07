package sut.ist912m.lobanov.logger;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sut.ist912m.lobanov.pojo.Data;

import java.util.Collection;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(Log)")
    public void logPointcut() {
    }

    @AfterReturning(pointcut = "logPointcut()", returning = "data")
    public void printLog(Collection<Data> data) {
        for (Data d: data){
            logger.info(d.toString());
        }
    }



}
