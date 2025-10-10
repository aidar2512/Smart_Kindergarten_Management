package kg.mega.smart_kindergarten_management.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class, GroupCategoryMapper.class})
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toEntity(GroupCreateDto dto);
    GroupDto toDto(Group entity);
}
