package kg.mega.smart_kindergarten_management.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupCategoryService {
    GroupCategoryDto create(GroupCategoryCreateDto dto);
    GroupCategoryDto update(Long id, GroupCategoryCreateDto dto);
    void delete(Long id);
    GroupCategoryDto findById(Long id);
    Page<GroupCategoryDto> findAll(Pageable pageable);
}
