package com.yemeksepeti.demo.mapper;

import com.yemeksepeti.demo.dto.request.CustomerSaveRequestDto;
import com.yemeksepeti.demo.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrdersMapper {

    IOrdersMapper INSTANCE = Mappers.getMapper(IOrdersMapper.class);

    Customer customerFromDto (CustomerSaveRequestDto dto);
}
