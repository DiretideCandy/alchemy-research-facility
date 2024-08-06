package ru.ct.alchemy.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private String text;
    private String result;
    private String experimentCreatedBy;
    private String experimentApprovedBy;
    private String experimentLastUpdatedBy;
    private Long experimentId;
}
