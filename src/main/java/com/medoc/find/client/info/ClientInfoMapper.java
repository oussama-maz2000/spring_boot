package com.medoc.find.client.info;

import com.medoc.find.client.dao.cretiria.ClientInfoCriteria;
import com.medoc.find.client.dao.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientInfoMapper {

    @Mapping(target = "fullName", expression = "java(buildFullName(entity))")
    ClientInfoDTO mapFromClientEntity(ClientEntity entity);

    List<ClientInfoDTO> mapFromClientEntities(List<ClientEntity> entities);

    ClientEntity mapfromobjectEntity(ClientInfoDTO clientInfoDTO);

    default String buildFullName(ClientEntity entity) {

        if (entity == null) {
            return null;
        }

        return entity.getLastName() + " " + entity.getName();

    }

    ClientInfoCriteria mapFromRequest(ClientInfoCriteriaRequest request);

}
