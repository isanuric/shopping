package com.prismaplaza.shopping.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;



    /**
     * Das @OneToMany(mappedBy = "user") in der Entität User besagt, dass es eine
     * One-to-Many-Beziehung zwischen der Entität User und der Entität Order gibt.
     * Dabei wird die Beziehung von der anderen Seite aus definiert, d.h. in der
     * Entität Order gibt es ein @ManyToOne-Mapping auf die Entität User. Das
     * mappedBy-Attribut gibt den Namen des Attributs in der anderen Entität an,
     * über das die Beziehung verwaltet wird, in diesem Fall das Attribut user
     * in der Entität Order. Mit dem Attribut orders in der Entität User wird
     * die Beziehung von der Seite der Entität User aus definiert, d.h. ein
     * User-Objekt kann eine Liste von Order-Objekten haben.
     */
//    @OneToMany(mappedBy = "user")
//    private List<Order> orders;


    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
