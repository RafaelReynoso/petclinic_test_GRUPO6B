package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.VetTO;

import com.tecsup.petclinic.entities.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface VetMapper {

    VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);

    @Mapping(source = "first_name", target = "first_name")
        Vet toVet(VetTO vetTO);

    @Mapping(source = "first_name", target = "first_name")
        VetTO tovetTO(Vet vet);





    List<VetTO> toVetTOList(List<Vet> vetList);
    List<Vet> toVetList(List<VetTO> petTOList);



}