package io.ramya.service;


import io.ramya.entity.Employee;
import io.ramya.exception.BadRequestException;
import io.ramya.exception.ResourceNotFoundException;
import io.ramya.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

   // @Transactional(readOnly = true)
    public List<Employee> findAll()
    {

        return repository.findAll();
    }
   // @Transactional(readOnly = true)
    public Employee findOne(String id) {
            Employee existing = null; //repository.findOne(id);
            if(existing == null)
            {
                // exception handling
                throw new ResourceNotFoundException("Employee with id" +id+ "doesn't exists.");
            }
            return existing;
    }
    @Transactional
    public Employee create(Employee emp)
    {
        Employee existing = repository.findByEmail(emp.getEmail());
        if(existing!=null)
        {
            //exception handling, 404 Bad Request
            throw new BadRequestException("Employee with email" +emp.getEmail()+ "already exists.");
        }
        return repository.create(emp);
    }
    @Transactional
    public Employee update(String id, Employee emp)
    {
        Employee existing = repository.findOne(id);
        if(existing==null){
            //exception handing 404 error
            throw new ResourceNotFoundException("Employee with id" +id+ "doesn't exists.");
        }
        return repository.update(emp);
    }

    @Transactional
    public void delete(String id) {
        Employee existing = repository.findOne(id);
        if(existing==null){
            //exception handing 404 error
            throw new ResourceNotFoundException("Employee with id" +id+ "doesn't exists.");
        }
        repository.delete(existing);
    }
}
