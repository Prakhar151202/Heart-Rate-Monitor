package com.heartratemonitor.HeartRateMonitor.dto;


import lombok.*;
import org.hibernate.validator.constraints.Normalized;

@Data
@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class PatientDto {
    private Long patientId;
    private String patientName;
    private Integer heartRate;

}
