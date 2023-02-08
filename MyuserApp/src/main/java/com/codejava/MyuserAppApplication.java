package com.codejava;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import com.codejava.model.Course;
import com.codejava.model.Student;
import com.codejava.model.UserDtls;
import com.codejava.repository.CourseRepository;
import com.codejava.repository.StudentRepository;
import com.codejava.repository.UserRepository;



@SpringBootApplication
public class MyuserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyuserAppApplication.class, args);
		
		
	}
	@Bean
	public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			// save students
			repository.save(new Student("John", "Johnson", "IT", "john@john.com")); 
			repository.save(new Student("Steve", "Stevens", "IT", "steve.stevent@st.com"));
			repository.save(new Student("Mary", "Robinson", "IT", "mary@robinson.com"));
			repository.save(new Student("Kate", "Keystone", "Nursery","kate@kate.com"));
			repository.save(new Student("Diana", "Doll", "Business","diana@doll.com"));
			
			Stream.of("Programming Java", "Spring Boot basics", "Marketing 1", "Marketing 2").forEach(name -> {
				crepository.save(new Course(name));
			});

			// Create users with BCrypt encoded password (user/user, admin/admin)
//			UserDtls user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
//			UserDtls user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
//			urepository.saveAll(Arrays.asList(user1, user2));
		};
	}

}
