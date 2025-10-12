package kg.mega.smart_kindergarten_management.mappers;


import kg.mega.smart_kindergarten_management.models.Group;
import kg.mega.smart_kindergarten_management.models.dto.GroupCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class, GroupCategoryMapper.class})
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toEntity(GroupCreateDto dto);
    GroupDto toDto(Group entity);
}

