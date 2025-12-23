package org.example.dabacolis.dto.colis;

import org.example.dabacolis.dto.user.UserResponse;
import org.example.dabacolis.enums.ColisStatus;
import org.example.dabacolis.enums.ColisType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ColisResponse {
    private String id;
    private ColisType type;
    private double poids;
    private String adresseDestination;
    private ColisStatus statut;


    private UserResponse transporteur;


    private String instructionsManutention;
    private Double temperatureMin;
    private Double temperatureMax;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}