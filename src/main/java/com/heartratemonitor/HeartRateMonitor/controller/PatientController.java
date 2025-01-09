package com.heartratemonitor.HeartRateMonitor.controller;

import com.heartratemonitor.HeartRateMonitor.dto.HeartRateUpdateDto;
import com.heartratemonitor.HeartRateMonitor.dto.NewPatientDto;
import com.heartratemonitor.HeartRateMonitor.dto.PatientDto;
import com.heartratemonitor.HeartRateMonitor.exceptions.ResourceNotFoundException;
import com.heartratemonitor.HeartRateMonitor.model.Patient;
import com.heartratemonitor.HeartRateMonitor.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;


    @PostMapping("/addPatient")
    public ResponseEntity<?> addPatient(@RequestBody @Valid NewPatientDto newpatientDto) {
        // Map PatientDto to Patient entity
        Patient patient = new Patient();
        patient.setPatientName(newpatientDto.getPatientName());
        patient.setAge(newpatientDto.getAge());
        patient.setGender(newpatientDto.getGender());
        patient.setContact(newpatientDto.getContact());
        patient.setHeartRate(newpatientDto.getHeartRate());

        // Save the patient to the database
        Patient savedPatient = patientRepository.save(patient);
        // Return success response
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @GetMapping("/allPatient")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    // API to fetch heart rate of a patient
    @GetMapping("/heartrate/{patientId}")
    public ResponseEntity<PatientDto> findHeartRate(@PathVariable("patientId") @NonNull Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        // Map the Patient entity to the PatientDto
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setPatientName(patient.getPatientName());
        patientDto.setHeartRate(patient.getHeartRate());


        return ResponseEntity.ok(patientDto);
    }
    // API to record a heart rate of a patient
    @PutMapping("/heartrate/{patientId}")
    public ResponseEntity<String> updateHeartRate(
            @PathVariable("patientId") @NonNull Long patientId,
            @RequestBody @Valid HeartRateUpdateDto heartRateUpdateDto) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        patient.setHeartRate(heartRateUpdateDto.getHeartRate());
        patientRepository.save(patient);

        return ResponseEntity.ok("Heart rate updated successfully for patient ID: " + patientId);
    }
}
