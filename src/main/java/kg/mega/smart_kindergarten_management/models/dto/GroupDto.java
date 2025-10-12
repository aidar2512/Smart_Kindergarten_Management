package kg.mega.smart_kindergarten_management.models.dto;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private Integer maxChildrenCount;
    private Integer price;
    private TeacherDto nanny;
    private TeacherDto teacher;
    private GroupCategoryDto groupCategory;
}

