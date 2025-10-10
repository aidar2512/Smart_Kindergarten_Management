package kg.mega.smart_kindergarten_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryDto;
import kg.mega.smart_kindergarten_management.services.GroupCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group-category")
@RequiredArgsConstructor
public class GroupCategoryController {

    private final GroupCategoryService service;

    @PostMapping
    @Operation(summary = "Создание категории групп")
    public ResponseEntity<GroupCategoryDto> create(@RequestBody GroupCategoryCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновление категории групп")
    public ResponseEntity<GroupCategoryDto> update(@PathVariable Long id, @RequestBody GroupCategoryCreateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление категории групп")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Категория успешно удалена");
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение категории по ID")
    public ResponseEntity<GroupCategoryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @Operation(summary = "Получение списка категорий с пагинацией")
    public ResponseEntity<Page<GroupCategoryDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
