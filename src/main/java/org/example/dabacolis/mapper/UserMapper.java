package org.example.dabacolis.mapper;

import org.example.dabacolis.dto.user.TransporteurRequest;
import org.example.dabacolis.dto.user.UserResponse;
import org.example.dabacolis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(User user);


    @Mapping(target = "role", constant = "TRANSPORTEUR")
//    @Mapping(target = "active", constant = "true")
//    @Mapping(target = "status", constant = "DISPONIBLE")
    User toTransporteurEntity(TransporteurRequest request);
}