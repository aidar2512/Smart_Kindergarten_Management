package kg.mega.smart_kindergarten_management.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toEntity(PaymentCreateDto dto);
    @Mapping(source = "groupChildren.id", target = "groupChildrenId")
    PaymentDto toDto(Payment entity);
}
