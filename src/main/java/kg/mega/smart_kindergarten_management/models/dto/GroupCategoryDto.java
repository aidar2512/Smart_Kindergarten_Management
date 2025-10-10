package kg.mega.smart_kindergarten_managementtryal.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class GroupCategoryDto {
    private Long id;
    private String name;
    private Boolean active;
    private Integer price;
}

