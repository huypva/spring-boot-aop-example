package io.codebyexample.springbootaop.aop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class TimeLoggerAspectJ {

  @Pointcut("@annotation(timeLogger)")
  public void annotatedTimeLogger(TimeLogger timeLogger) {
  }

  @Around("annotatedTimeLogger(timeLogger)")
  public Object around(ProceedingJoinPoint joinPoint, TimeLogger timeLogger) throws Throwable {
    String value = timeLogger.value();
    long startTime = System.currentTimeMillis();

    try {
      return joinPoint.proceed();
    } finally {

      long processTime = System.currentTimeMillis() - startTime;
      log.info(String.format("Process [%s] in [%s]", value, processTime));
    }

  }
}
