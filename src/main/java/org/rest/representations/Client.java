package org.rest.representations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @NotNull
    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Getter @Setter
    private String email;

    public Client(Long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;

    }
}
