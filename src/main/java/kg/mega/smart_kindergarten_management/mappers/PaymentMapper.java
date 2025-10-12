package kg.mega.smart_kindergarten_management.mappers;

import kg.mega.smart_kindergarten_management.models.Payment;
import kg.mega.smart_kindergarten_management.models.dto.PaymentCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.PaymentDto;
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

