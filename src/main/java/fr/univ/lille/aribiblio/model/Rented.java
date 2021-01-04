package fr.univ.lille.aribiblio.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@Entity
@Table(name="T_RENTED")
@IdClass(RentedId.class)
@AllArgsConstructor
@NoArgsConstructor
public class Rented {

    @Id
    @Column(name = "user_id")
    Integer userId;

    @Id
    @Column(name = "book_id")
    Integer bookId;

}
