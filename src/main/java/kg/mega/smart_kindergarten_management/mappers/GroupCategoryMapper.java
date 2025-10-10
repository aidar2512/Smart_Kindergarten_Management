package kg.mega.smart_kindergarten_management.mappers;

import kg.mega.smart_kindergarten_management.models.GroupCategory;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupCategoryMapper {
    GroupCategoryMapper INSTANCE = Mappers.getMapper(GroupCategoryMapper.class);

    GroupCategory toEntity(GroupCategoryCreateDto dto);
    GroupCategoryDto toDto(GroupCategory entity);
}
