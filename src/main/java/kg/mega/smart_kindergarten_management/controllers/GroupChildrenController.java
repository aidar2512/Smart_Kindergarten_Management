package kg.mega.smart_kindergarten_management.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildDto;
import kg.mega.smart_kindergarten_management.models.dto.WithdrawChildDto;
import kg.mega.smart_kindergarten_management.services.GroupChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group-children")
@Tag(name = "Group Children Controller", description = "Управление детьми")
@RequiredArgsConstructor
public class GroupChildrenController {

    private final GroupChildrenService service;

    @PostMapping
    @Operation(summary = "Зачисление ребенка в группу")
    public ResponseEntity<EnrollChildDto> enroll(@RequestBody EnrollChildCreateDto dto) {
        return ResponseEntity.ok(service.enroll(dto));
    }

    @PutMapping("/{id}/withdraw")
    @Operation(summary = "Отчисление ребенка из группы")
    public ResponseEntity<EnrollChildDto> withdraw(@PathVariable Long id, @RequestBody WithdrawChildDto dto) {
        return ResponseEntity.ok(service.withdraw(id, dto));
    }
}

