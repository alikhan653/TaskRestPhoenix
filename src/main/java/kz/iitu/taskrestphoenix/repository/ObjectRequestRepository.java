package kz.iitu.taskrestphoenix.repository;


import kz.iitu.taskrestphoenix.model.ObjectRequest;
import kz.iitu.taskrestphoenix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRequestRepository extends JpaRepository<ObjectRequest, Long> {
}
