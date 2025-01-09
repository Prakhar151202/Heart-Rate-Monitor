package com.heartratemonitor.HeartRateMonitor.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class HeartRateUpdateDto {
    @Min(value = 30, message = "Heart rate must be at least 30 bpm.")
    @Max(value = 200, message = "Heart rate must not exceed 200 bpm.")
    private Integer heartRate;
}
