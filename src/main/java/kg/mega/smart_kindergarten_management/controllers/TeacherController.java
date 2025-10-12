package kg.mega.smart_kindergarten_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mega.smart_kindergarten_management.models.dto.TeacherCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.TeacherDto;
import kg.mega.smart_kindergarten_management.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@Tag(name = "Teacher Controller", description = "Управление учителями")
@RequiredArgsConstructor
public class TeacherController implements CRUDController<TeacherCreateDto, TeacherDto> {

    private final TeacherService service;

    @Override
    @Operation(summary = "Создание сущности учителя")
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    @Operation(summary = "Обновление сущности учителя")
    public ResponseEntity<TeacherDto> update(@PathVariable Long id, @RequestBody TeacherCreateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    @Operation(summary = "Поиск учителя по айди")
    public ResponseEntity<TeacherDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    @Operation(summary = "Вывод всех учителей с пагинацией")
    public ResponseEntity<Page<TeacherDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @Override
    @Operation(summary = "Удаление сущности учителя")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
