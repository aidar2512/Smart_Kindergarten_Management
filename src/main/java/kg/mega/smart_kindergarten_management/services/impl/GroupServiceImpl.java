package kg.mega.smart_kindergarten_management.services.impl;

import kg.mega.smart_kindergarten_management.exception.ConflictException;
import kg.mega.smart_kindergarten_management.exception.NotFoundException;
import kg.mega.smart_kindergarten_management.mappers.GroupMapper;
import kg.mega.smart_kindergarten_management.models.Group;
import kg.mega.smart_kindergarten_management.models.GroupCategory;
import kg.mega.smart_kindergarten_management.models.Teacher;
import kg.mega.smart_kindergarten_management.models.dto.GroupCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupDto;
import kg.mega.smart_kindergarten_management.repositories.GroupCategoryRepo;
import kg.mega.smart_kindergarten_management.repositories.GroupChildrenRepo;
import kg.mega.smart_kindergarten_management.repositories.GroupRepo;
import kg.mega.smart_kindergarten_management.repositories.TeacherRepo;
import kg.mega.smart_kindergarten_management.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;
    private final TeacherRepo teacherRepo;
    private final GroupCategoryRepo catRepo;
    private final GroupChildrenRepo groupChildrenRepo;
    private final GroupMapper mapper;

    @Override
    public GroupDto create(GroupCreateDto dto) {
        if (groupRepo.existsByName(dto.getName())) {
            throw new ConflictException("Группа с таким названием уже существует");
        }

        Teacher nanny = teacherRepo.findById(dto.getNannyId())
                .orElseThrow(() -> new NotFoundException("Няня не найдена"));
        Teacher teacher = teacherRepo.findById(dto.getTeacherId())
                .orElseThrow(() -> new NotFoundException("Учитель не найден"));
        GroupCategory cat = catRepo.findById(dto.getGroupCategoryId())
                .orElseThrow(() -> new NotFoundException("Категория не найдена"));

        if (!cat.getActive()) {
            throw new ConflictException("Категория групп неактивна, нельзя создать группу");
        }
        if (!teacher.getActive()) {
            throw new ConflictException("Учитель неактивен");
        }
        if (!nanny.getActive()) {
            throw new ConflictException("Няня неактивна");
        }

        Group group = mapper.toEntity(dto);
        group.setNanny(nanny);
        group.setTeacher(teacher);
        group.setGroupCategory(cat);
        return mapper.toDto(groupRepo.save(group));
    }

    @Override
    public GroupDto update(Long id, GroupCreateDto dto) {
        Group group = groupRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Группа не найдена"));

        if (!group.getName().equals(dto.getName()) && groupRepo.existsByName(dto.getName())) {
            throw new ConflictException("Группа с таким названием уже существует");
        }


        group.setName(dto.getName());
        group.setPrice(dto.getPrice());
        group.setMaxChildrenCount(dto.getMaxChildrenCount());

        return mapper.toDto(groupRepo.save(group));
    }

    @Override
    public GroupDto findById(Long id) {
        return groupRepo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Группа не найдена"));
    }

    @Override
    public void delete(Long id) {
        Group group = groupRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Группа не найдена"));

        if (groupChildrenRepo.existsByGroup_IdAndEndDateIsNull(group.getId())) {
            throw new ConflictException("Нельзя удалить группу, в которой есть дети");
        }

        groupRepo.deleteById(id);
    }

    @Override
    public Page<GroupDto> findAll(Pageable pageable) {
        return groupRepo.findAll(pageable).map(mapper::toDto);
    }
}

