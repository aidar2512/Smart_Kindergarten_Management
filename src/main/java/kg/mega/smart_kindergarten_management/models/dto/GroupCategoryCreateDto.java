package kg.mega.smart_kindergarten_management.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GroupCategoryCreateDto {

    @NotBlank(message = "Название категории обязательно")
    String name;

    @NotNull(message = "Статус активности обязателен")
    boolean active;

    @NotNull(message = "Цена обязательна")
    @Positive(message = "Цена должна быть положительной")
    double price;


}
