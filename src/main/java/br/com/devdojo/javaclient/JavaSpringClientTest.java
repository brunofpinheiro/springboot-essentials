package br.com.devdojo.javaclient;

import br.com.devdojo.model.Student;

import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {

        Student studentPost = new Student();
        studentPost.setName("John Wick");
        studentPost.setEmail("john@pencil.com");

        JavaClienteDAO dao = new JavaClienteDAO();
//        System.out.println(dao.findById(1));
        List<Student> students = dao.listAll();
        System.out.println(students);
//        System.out.println(dao.save(studentPost));
    }
}
