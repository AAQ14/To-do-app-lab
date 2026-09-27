package com.ga.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public String profileDescription;

    @OneToOne(mappedBy = "userProfile", fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

}
