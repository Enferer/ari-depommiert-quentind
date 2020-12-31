package fr.univ.lille.aridepommiert.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="T_AUTHOR")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_author")
    Integer id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

}
