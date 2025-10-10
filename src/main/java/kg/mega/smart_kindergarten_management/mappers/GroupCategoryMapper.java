package kg.mega.smart_kindergarten_management.mappers;

import kg.mega.smart_kindergarten_managementtryal.models.GroupCategory;
import kg.mega.smart_kindergarten_managementtryal.models.dto.GroupCategoryCreateDto;
import kg.mega.smart_kindergarten_managementtryal.models.dto.GroupCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupCategoryMapper {
    GroupCategoryMapper INSTANCE = Mappers.getMapper(GroupCategoryMapper.class);

    GroupCategory toEntity(GroupCategoryCreateDto dto);
    GroupCategoryDto toDto(GroupCategory entity);
}
