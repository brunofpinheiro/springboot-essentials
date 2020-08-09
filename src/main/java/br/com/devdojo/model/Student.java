package br.com.devdojo.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
    @NotEmpty(message = "O campo nome do estudante é obrigatório")
    private String name;

    @Email(message = "Digite um email válido")
    @NotEmpty
    private String email;

    public Student() {
    }

    public Student(@NotEmpty(message = "O campo nome do estudante é obrigatório") String name, @Email @NotEmpty String email) {
        this.name = name;
        this.email = email;
    }

    public Student(long id, @NotEmpty(message = "O campo nome do estudante é obrigatório") String name, @Email @NotEmpty String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
