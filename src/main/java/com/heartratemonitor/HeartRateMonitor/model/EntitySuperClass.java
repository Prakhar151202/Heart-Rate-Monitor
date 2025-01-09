package com.heartratemonitor.HeartRateMonitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class EntitySuperClass {
    @Id
    private String email;
    private String password;
}
