package kg.mega.smart_kindergarten_management.mappers;

import kg.mega.smart_kindergarten_management.models.Child;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    Child toEntity(EnrollChildCreateDto dto);
    EnrollChildDto toDto(Child entity);
}
