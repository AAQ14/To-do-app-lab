package com.ga.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@ToString(exclude = {"password", "userProfile"})
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String emailAddress;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @JsonIgnore
    public String getPassword(){
        return password;
    }
}
