package kg.mega.smart_kindergarten_management.services.impl;

import kg.mega.smart_kindergarten_management.exception.ConflictException;
import kg.mega.smart_kindergarten_management.exception.NotFoundException;
import kg.mega.smart_kindergarten_management.mappers.TeacherMapper;
import kg.mega.smart_kindergarten_management.models.Teacher;
import kg.mega.smart_kindergarten_management.models.dto.TeacherCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.TeacherDto;
import kg.mega.smart_kindergarten_management.repositories.TeacherRepo;
import kg.mega.smart_kindergarten_management.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo repository;
    private final TeacherMapper mapper;

    @Override
    public TeacherDto create(TeacherCreateDto dto) {
        if (repository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(dto.getFirstName(), dto.getLastName())) {
            throw new ConflictException("Такой учитель уже существует");
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public TeacherDto update(Long id, TeacherCreateDto dto) {
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Учитель не найден"));

        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setPatronymic(dto.getPatronymic());
        teacher.setTeacherDegree(dto.getTeacherDegree());
        teacher.setActive(dto.getActive());

        return mapper.toDto(repository.save(teacher));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Учитель не найден");
        }
        repository.deleteById(id);
    }

    @Override
    public TeacherDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Учитель не найден"));
    }

    @Override
    public Page<TeacherDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
