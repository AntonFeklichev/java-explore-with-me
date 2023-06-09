package ru.practicum.ewm.main.server.category.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.server.category.dto.CategoryDto;
import ru.practicum.ewm.main.server.category.entity.Category;
import ru.practicum.ewm.main.server.config.mapstruct.CentralMapperConfig;

@Mapper(config = CentralMapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

}