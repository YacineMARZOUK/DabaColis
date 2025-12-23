package org.example.dabacolis.validator;

import org.example.dabacolis.entity.Colis;
import org.example.dabacolis.entity.User;
import org.example.dabacolis.enums.ColisType;
import org.example.dabacolis.enums.Speciality;
import org.example.dabacolis.enums.UserRole;
import org.example.dabacolis.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class BusinessRulesValidator {


    public void validateAssignment(Colis colis, User transporteur) {

        if (transporteur.getRole() != UserRole.TRANSPORTEUR) {
            throw new BusinessException("User " + transporteur.getLogin() + " is not a TRANSPORTEUR.");
        }


        if (!transporteur.isActive()) {
            throw new BusinessException("Transporteur " + transporteur.getLogin() + " is currently inactive.");
        }


        if (!isCompatible(colis.getType(), transporteur.getSpeciality())) {
            throw new BusinessException(String.format(
                    "Incompatible Assignment: Colis is %s but Transporteur speciality is %s",
                    colis.getType(), transporteur.getSpeciality()
            ));
        }
    }

    private boolean isCompatible(ColisType colisType, Speciality speciality) {

        if (colisType == null || speciality == null) return false;
        return colisType.name().equals(speciality.name());
    }
}