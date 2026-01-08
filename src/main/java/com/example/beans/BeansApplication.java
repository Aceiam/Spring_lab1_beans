package com.example.beans;

import com.example.beans.model.University;
import com.example.beans.model.Faculty;
import com.example.beans.model.Department;
import com.example.beans.model.Dean;
import com.example.beans.repository.UniversityRepository;
import com.example.beans.repository.FacultyRepository;
import com.example.beans.repository.DepartmentRepository;
import com.example.beans.repository.DeanRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeansApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BeansApplication.class, args);

        // Репозиторії
        UniversityRepository universityRepo = context.getBean(UniversityRepository.class);
        FacultyRepository facultyRepo = context.getBean(FacultyRepository.class);
        DepartmentRepository departmentRepo = context.getBean(DepartmentRepository.class);
        DeanRepository deanRepo = context.getBean(DeanRepository.class);

        // Створюємо університет
        University university = new University();
        university.setTitle("My University");
        universityRepo.save(university);

        // Створюємо декана
        Dean dean = new Dean();
        dean.setFullName("John Smith");
        dean.setEmail("johnSmith_" + System.currentTimeMillis() + "@jjj.com");
        deanRepo.save(dean);

        // Створюємо факультет і прив'язуємо до університету та декана
        Faculty faculty = new Faculty();
        faculty.setTitle("Computer Science");
        faculty.setUniversity(university);
        faculty.setDean(dean);
        facultyRepo.save(faculty);

        // Створюємо департамент і прив'язуємо до факультету
        Department department = new Department();
        department.setName("Software Engineering");
        department.setFaculty(faculty);
        departmentRepo.save(department);

        // Вивід даних
        System.out.println("University: " + university.getTitle());
        for (Faculty f : facultyRepo.findAll()) {
            System.out.println("Faculty: " + f.getTitle() + ", Dean: " + (f.getDean() != null ? f.getDean().getFullName() : "none"));
            for (Department d : departmentRepo.findAll()) {
                if (d.getFaculty().getId().equals(f.getId())) {
                    System.out.println("Department: " + d.getName());
                }
            }
        }
    }
}
