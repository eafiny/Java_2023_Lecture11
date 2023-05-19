package ru.muctr.PRELibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Evgenia Skichko
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "prepods")
public class Prepod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 2, message = "Min length of name = 2")
    @Column(name = "name")
    private String name;

    @Min(value = 10000, message = "Min salary = 10000")
    @Column(name = "salary")
    private int salary;

    @Transient
    private String rang;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;

    @Override
    public String toString() {
        return "Prepod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Prepod(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public Prepod(String name, int salary, Integer id){
        this.name = name;
        this.salary = salary;
        this.id = id;
    }
}
