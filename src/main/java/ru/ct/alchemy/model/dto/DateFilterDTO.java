package ru.ct.alchemy.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DateFilterDTO {
    private Date from;
    private Date to;
}
