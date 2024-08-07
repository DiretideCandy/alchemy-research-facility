package ru.ct.alchemy.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DateFilterStringDTO {
    private String from;
    private String to;

    public static DateFilterStringDTO createEmpty() {
        return new DateFilterStringDTO(null, null);
    }
}
