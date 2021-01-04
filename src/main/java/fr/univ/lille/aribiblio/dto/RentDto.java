package fr.univ.lille.aribiblio.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentDto {

    private String userName;

    private String bookName;

    private Integer bookId;

}
