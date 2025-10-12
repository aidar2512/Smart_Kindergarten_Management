package kg.mega.smart_kindergarten_management.services;

import kg.mega.smart_kindergarten_management.models.dto.GroupCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    GroupDto create(GroupCreateDto dto);
    GroupDto update(Long id, GroupCreateDto dto);
    GroupDto findById(Long id);
    void delete(Long id);
    Page<GroupDto> findAll(Pageable pageable);
}
