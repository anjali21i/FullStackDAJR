package com.core.fullstack.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.Data;

@SpringBootApplication
public class JdbcWithSpringData implements CommandLineRunner {

    @Autowired
    private MyEntityService entityService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcWithSpringData.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        entityService.performOperations();
    }
}

interface UserDataRepository extends JpaRepository<UserData, Long> {
}

@Data
@Entity
class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int age;
}


@Service
class MyEntityService {
    @Autowired
    private UserDataRepository repository;

    @Transactional
    public void performOperations() {
        try {
        	UserData entity1 = new UserData();
            entity1.setName("Anjali");
            entity1.setAge(26);
            repository.save(entity1);

            UserData entity2 = repository.findById(2L).orElse(null);
            if (entity2 != null) {
                entity2.setEmail("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // This will rollback the transaction
        }
    }
}


