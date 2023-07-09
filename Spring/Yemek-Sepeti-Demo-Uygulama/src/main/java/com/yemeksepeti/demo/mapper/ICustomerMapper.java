package com.yemeksepeti.demo.mapper;

import com.yemeksepeti.demo.dto.request.CustomerSaveRequestDto;
import com.yemeksepeti.demo.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer customerFromDto (CustomerSaveRequestDto dto);
}
