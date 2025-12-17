package com.example.beans.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UniversityAspect {

    // Pointcut: всі методи класу University
    @Pointcut("execution(* com.example.beans.model.University.*(..))")
    public void universityMethods() {}

    // Pointcut: всі методи класу Faculty
    @Pointcut("execution(* com.example.beans.model.Faculty.*(..))")
    public void facultyMethods() {}

    // Комбінований Pointcut: будь-який метод University або Faculty
    @Pointcut("universityMethods() || facultyMethods()")
    public void universityOrFacultyMethods() {}

    // Advice Before: для будь-якого методу University або Faculty
    @Before("universityOrFacultyMethods()")
    public void beforeUniversityOrFaculty() {
        System.out.println("[Aspect Before] Метод University або Faculty викликається");
    }

    // Advice Before конкретно для University
    @Before("universityMethods()")
    public void beforeUniversityMethod() {
        System.out.println("[Aspect Before] Виконується метод University");
    }

    // Advice Around для Faculty
    @Around("facultyMethods()")
    public Object aroundFacultyMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Aspect Around] Початок Faculty методу: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // викликаємо оригінальний метод
        System.out.println("[Aspect Around] Кінець Faculty методу: " + joinPoint.getSignature().getName());
        return result;
    }

    // Advice AfterReturning для University
    @AfterReturning(
            pointcut = "universityMethods()",
            returning = "result"
    )
    public void afterReturningUniversity(Object result) {
        System.out.println("[Aspect AfterReturning] Метод University успішно завершився, результат: " + result);
    }

    // Advice AfterThrowing для Faculty
    @AfterThrowing(
            pointcut = "facultyMethods()",
            throwing = "ex"
    )
    public void afterThrowingFaculty(Exception ex) {
        System.out.println("[Aspect AfterThrowing] Метод Faculty завершився з помилкою: " + ex.getMessage());
    }
}
