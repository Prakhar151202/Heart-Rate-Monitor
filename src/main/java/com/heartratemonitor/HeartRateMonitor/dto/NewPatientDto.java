package com.heartratemonitor.HeartRateMonitor.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPatientDto {

    @NotBlank(message = "Patient name is required")
    @Size(max = 100, message = "Patient name must not exceed 100 characters")
    private String patientName;

    @NotBlank(message = "Age is required")
    @Pattern(regexp = "^[0-9]+$", message = "Age must be a valid number")
    private String age;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a valid 10-digit number")
    private String contact;

    @NotNull(message = "Heart rate is required")
    @Min(value = 40, message = "Heart rate must be at least 40")
    @Max(value = 200, message = "Heart rate must not exceed 200")
    private Integer heartRate;
}
