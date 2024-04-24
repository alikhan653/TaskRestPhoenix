package kz.iitu.taskrestphoenix.repository;


import kz.iitu.taskrestphoenix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
