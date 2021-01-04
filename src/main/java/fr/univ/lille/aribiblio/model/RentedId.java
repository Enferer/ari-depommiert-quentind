package fr.univ.lille.aribiblio.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class RentedId implements Serializable {

    private Integer userId;

    private Integer bookId;

}
