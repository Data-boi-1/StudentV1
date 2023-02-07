package com.example.studentv1.model;

import com.example.studentv1.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

  @Autowired
  StudentRepository studentRepository;

  @Test
  void testViggo(){
    Optional<Student> std = studentRepository.findById(10);
    if (std.isPresent()) {
      Student s1 = std.get();
      assertEquals(1, s1.getId());
    } else { assertEquals("det gik skidt", "");
    }
  }

  //assertEquals. Asserts that two objects are equal. If they are not, an AssertionError without a message is thrown.
  // If expected and actual are null , they are considered equal.

  @Test
  void testViggoOneLine(){
    assertEquals(1, studentRepository.findById(1).orElse(new Student()).getId());
  }

  @Test
  void testStudentByName(){
    assertEquals("Viggo", studentRepository.findByName("Viggo").orElse(new Student()).getName());
  }


}