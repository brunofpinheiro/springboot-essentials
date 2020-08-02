package br.com.devdojo.javaclient;

import br.com.devdojo.model.PageableResponse;
import br.com.devdojo.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/students")
                .basicAuthentication("toyo", "devdojo")
                .build();
        Student student = restTemplate.getForObject("/{id}", Student.class, 1);
        ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
        System.out.println(student);
        System.out.println(forEntity.getBody());
//        Student[] students = restTemplate.getForObject("/", Student[].class, 1);
//        System.out.println(Arrays.toString(students));
//        ResponseEntity<List<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
//        System.out.println(exchange.getBody());
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/?sort=id,desc&sort=name,asc", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {});
        System.out.println(exchange);
    }
}
