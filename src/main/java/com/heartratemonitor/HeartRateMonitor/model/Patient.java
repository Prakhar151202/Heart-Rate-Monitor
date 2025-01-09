package com.heartratemonitor.HeartRateMonitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;
    private String age;
    private String gender;
    private String contact;
    private Integer heartRate;

}
