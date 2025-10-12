package kg.mega.smart_kindergarten_management.models.dto;

import lombok.Data;

@Data
public class GroupCategoryDto {
    private Long id;
    private String name;
    private Boolean active;
    private Integer price;
}

