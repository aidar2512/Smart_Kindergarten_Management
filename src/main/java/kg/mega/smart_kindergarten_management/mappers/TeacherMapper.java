package kg.mega.smart_kindergarten_management.mappers;

import kg.mega.smart_kindergarten_management.models.Teacher;
import kg.mega.smart_kindergarten_management.models.dto.TeacherCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher toEntity(TeacherCreateDto dto);
    TeacherDto toDto(Teacher entity);
}
