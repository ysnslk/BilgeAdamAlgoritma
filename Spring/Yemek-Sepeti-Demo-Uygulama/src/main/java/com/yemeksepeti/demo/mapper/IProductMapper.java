package com.yemeksepeti.demo.mapper;

import com.yemeksepeti.demo.dto.request.ProductSaveRequestDto;
import com.yemeksepeti.demo.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product productFromDto (ProductSaveRequestDto dto);
}
