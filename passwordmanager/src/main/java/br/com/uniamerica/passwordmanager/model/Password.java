package br.com.uniamerica.passwordmanager.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "passwords", schema = "public")
public class Password {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "description", nullable = false)
    private String description;

    @Getter @Setter
    @Column(name = "url", nullable = false)
    private String url;

}
