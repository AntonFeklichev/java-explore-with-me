package ru.practicum.ewm.main.server.category.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewm.main.server.category.dto.PatchCategoryRequestDto;
import ru.practicum.ewm.main.server.category.dto.PatchCategoryResponseDto;
import ru.practicum.ewm.main.server.category.entity.Category;
import ru.practicum.ewm.main.server.config.mapstruct.CentralMapperConfig;

@Mapper(config = CentralMapperConfig.class)
public interface PatchCategoryMapper {
    PatchCategoryResponseDto toResponseDto(Category category);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(
            PatchCategoryRequestDto patchCategoryRequestDto,
            @MappingTarget
            Category category
    );
}