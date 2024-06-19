package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Teacher;
import com.sistema.ciao.sistema_ciao_backend.exception.TeacherAlreadyExistsException;
import com.sistema.ciao.sistema_ciao_backend.repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        Optional<Teacher> existingTeacherByEmail = teacherRepository.findTeacherByEmail(teacher.getEmail());
        Optional<Teacher> existingTeacherByCurp = teacherRepository.findTeacherByCurp(teacher.getCurp());

        if (existingTeacherByEmail.isPresent()) {
            throw new TeacherAlreadyExistsException("El email ya está registrado.");
        }

        if (existingTeacherByCurp.isPresent()) {
            throw new TeacherAlreadyExistsException("El CURP ya está registrado.");
        }

        return teacherRepository.save(teacher);
    }
}
