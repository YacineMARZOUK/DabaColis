package logistics.mapper;

import logistics.dto.user.TransporteurRequest;
import logistics.dto.user.UserResponse;
import logistics.entity.User;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(User user);


    @Mapping(target = "role", constant = "TRANSPORTEUR")
//    @Mapping(target = "active", constant = "true")
//    @Mapping(target = "status", constant = "DISPONIBLE")
    User toTransporteurEntity(TransporteurRequest request);
}