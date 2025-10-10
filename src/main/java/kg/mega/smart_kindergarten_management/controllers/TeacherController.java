package kg.mega.smart_kindergarten_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
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
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    @Operation(summary = "Создание учителя")
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновление данных учителя")
    public ResponseEntity<TeacherDto> update(@PathVariable Long id, @RequestBody TeacherCreateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление учителя")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Учитель успешно удален");
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение учителя по ID")
    public ResponseEntity<TeacherDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @Operation(summary = "Получение списка учителей с пагинацией")
    public ResponseEntity<Page<TeacherDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
