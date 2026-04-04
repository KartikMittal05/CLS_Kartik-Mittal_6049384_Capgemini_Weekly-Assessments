package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Emp;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repo;

    public List<Emp> getAll() {
        return repo.findAll();
    }

    public Emp getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Emp emp) {
        repo.save(emp);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}