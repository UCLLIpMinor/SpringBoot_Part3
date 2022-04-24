package com.example.springrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
    // n-n relationship with doctor
    @ManyToMany(cascade=CascadeType.ALL)
    // owning side
    private List<Doctor> doctors;

    // 1-n relationship with examination
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    // creates table patient_examinations
    // CascadeType.ALL = needed for add examination: you have a collection in your entity,
    // and that collection has one or more items which are not present
    // in the database. By specifying the above options you tell
    // hibernate to save them to the database when saving their parent.
    //@JoinColumn(name = "patient_id")
    // creates no extra table, but patient_id in examinations table
    @JoinTable(name="patient_examination", joinColumns={@JoinColumn(name="patient_id", referencedColumnName="id")}
            , inverseJoinColumns={@JoinColumn(name="examination_id", referencedColumnName="id")})
    // creates table patient_examination and patient_id in examination table
    private List<Examination> examinations;

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void addExamination(Examination examination) {
        examinations.add(examination);
        // bidirectional
        examination.setPatient(this);
    }

    public void deleteExamination(Examination examination) {
        examinations.remove(examination);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        doctor.addPatient(this);
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = false, nullable = false, length = 100)
    @NotBlank(message = "name.missing")
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    @NotBlank(message = "email.missing")
    @Email(message = "email.not.valid")
    private String email;

    @Column(name = "age", unique = false, nullable = false)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
