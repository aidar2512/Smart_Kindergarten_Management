package kg.mega.smart_kindergarten_management.models.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class GroupCreateDto {
    @NotBlank(message = "Название группы обязательно")
    private String name;

    @NotNull(message = "Максимальное количество детей обязательно")
    @Positive
    private Integer maxChildrenCount;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    private Long nannyId;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long groupCategoryId;
}

