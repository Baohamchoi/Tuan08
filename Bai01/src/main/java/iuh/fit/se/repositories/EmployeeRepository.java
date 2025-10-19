package iuh.fit.se.repositories;

import iuh.fit.se.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee " +
            "WHERE LOWER(firstName) LIKE LOWER(CONCAT('%', :keyName, '%')) " +
            "OR LOWER(lastName) LIKE LOWER(CONCAT('%', :keyName, '%'))",
            nativeQuery = true)
    List<Employee> findByKeyName(@Param("keyName") String keyName);
}
