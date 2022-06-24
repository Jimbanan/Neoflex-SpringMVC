package com.neoflex.spring.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "getAllUsers", query = "from Users")
@NamedQuery(name = "getUser", query = "select us from Users us where us.id = :id")
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Fullname should not be empty")
    @Size(min = 2, max = 50, message = "Fullname should be between 2 and 50 characters")
    private String fullname;

    @Column
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column
    @NotEmpty(message = "Phone should not be empty")
    @Size(min = 11, message = "Phone should be greater than 11")
    private String phone;

    @Column
    @NotEmpty(message = "Address should not be empty")
    @Size(min = 2, max = 50, message = "Address should be between 2 and 50 characters")
    private String address;

    @Column
    private LocalDate date_of_birth;

}
