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
@Table(name="T_BOOK")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_book")
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "author_id")
    Integer authorId;
}
