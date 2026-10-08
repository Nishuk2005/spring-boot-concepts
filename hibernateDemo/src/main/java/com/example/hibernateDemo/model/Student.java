package com.example.hibernateDemo.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            unique = true,
            nullable=false,
            length = 150,
            insertable = true,
            updatable = true
    )
    private String email;
    private int age;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "current_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "current_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "current_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "current_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "current_pincode")
            )
    })
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "permanent_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "permanent_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "permanent_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "permanent_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "permanent_pincode")
            )
    })
    private Address peramanentAddress;


    @Column(precision = 5,scale = 2)
    private BigDecimal percentage;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Lob
    private String profileDescription;

    @Transient
    private String displayName;

    private Boolean isMonitor;

    private LocalDateTime createdAt;

    public Student() {
    }

    public Student(Long id, String name, String email, int age, BigDecimal percentage, LocalDate dateOfBirth, StudentStatus status, String profileDescription, String displayName, Boolean isMonitor, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.percentage = percentage;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.profileDescription = profileDescription;
        this.displayName = displayName;
        this.isMonitor = isMonitor;
        this.createdAt = createdAt;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getMonitor() {
        return isMonitor;
    }

    public void setMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
