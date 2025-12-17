package com.example.beans;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UniversityAspect {

    // Pointcut: всі методи класу University
    @Pointcut("execution(* com.example.beans.University.*(..))")
    public void universityMethods() {}

    // Pointcut: всі методи класу Department
    @Pointcut("execution(* com.example.beans.Department.*(..))")
    public void departmentMethods() {}

    // Pointcut: всі методи класу Faculty
    @Pointcut("execution(* com.example.beans.Faculty.*(..))")
    public void facultyMethods() {}

    // Комбінований Pointcut: будь-який метод Department або Faculty
    @Pointcut("departmentMethods() || facultyMethods()")
    public void departmentOrFacultyMethods() {}

    // Advice для комбінованого Pointcut
    @Before("departmentOrFacultyMethods()")
    public void beforeDepartmentOrFaculty() {
        System.out.println("[Aspect] Метод Department або Faculty викликається");
    }

    // Advice 1: Before для University
    @Before("universityMethods()")
    public void beforeUniversityMethod() {
        System.out.println("Uni");
        System.out.println("[Aspect] Метод University викликається");
    }

    @Before("execution(* com.example.beans.Department.*(..)) && target(department)")
    public void checkDepartmentBeforeMethod(Department department) {
        if (department == null) {
            System.out.println("[Aspect Before] Department не створений!");
        } else if (department.getName() == null || department.getName().isEmpty()) {
            System.out.println("[Aspect Before] У Department не задано ім'я!");
        } else {
            System.out.println("[Aspect Before] Department готовий до виконання методу: " + department.getName());
        }
    }

    @After("execution(* com.example.beans.Department.*(..)) && target(department)")
    public void afterDepartmentMethod(Department department) {
        System.out.println("[Aspect After] Метод Department завершився для: " + department.getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.example.beans.Department.*(..))",
            returning = "result"
    )
    public void afterReturningDepartment(Object result) {
        System.out.println("[Aspect AfterReturning] Метод Department успішно завершився, результат: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.beans.Department.*(..))",
            throwing = "ex"
    )
    public void afterThrowingDepartment(Exception ex) {
        System.out.println("[Aspect AfterThrowing] Метод Department завершився з помилкою: " + ex.getMessage());
    }

    // Advice 3: Around для Faculty
    @Around("facultyMethods()")
    public Object aroundFacultyMethod(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Aspect] Початок виконання Faculty методу: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // викликаємо оригінальний метод
        System.out.println("[Aspect] Кінець виконання Faculty методу: " + joinPoint.getSignature().getName());
        return result;
    }
}
