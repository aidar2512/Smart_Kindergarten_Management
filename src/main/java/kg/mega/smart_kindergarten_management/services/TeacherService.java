package kg.mega.smart_kindergarten_management.services;

import kg.mega.smart_kindergarten_management.models.dto.TeacherCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.TeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    TeacherDto create(TeacherCreateDto dto);
    TeacherDto update(Long id, TeacherCreateDto dto);
    void delete(Long id);
    TeacherDto findById(Long id);
    Page<TeacherDto> findAll(Pageable pageable);
}
