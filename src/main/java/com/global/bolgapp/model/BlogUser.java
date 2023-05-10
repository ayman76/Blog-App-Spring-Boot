package com.global.bolgapp.model;

import java.util.Collection;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class BlogUser {

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please enter username")
    @Column(nullable = false, unique = true)
    private String username;

    @Length(min = MIN_PASSWORD_LENGTH, message = "Password must be at least " + MIN_PASSWORD_LENGTH
            + " characters long")
    @NotEmpty(message = "Please enter password")
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;
}
