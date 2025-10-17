package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public Employee findById(int id);
    public List<Employee> getAll();
    public void remove(int id);
}
