package kg.mega.smart_kindergarten_management.services.impl;

import kg.mega.smart_kindergarten_management.exception.ConflictException;
import kg.mega.smart_kindergarten_management.exception.NotFoundException;
import kg.mega.smart_kindergarten_management.mappers.ChildMapper;
import kg.mega.smart_kindergarten_management.models.Child;
import kg.mega.smart_kindergarten_management.models.Group;
import kg.mega.smart_kindergarten_management.models.GroupChildren;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildDto;
import kg.mega.smart_kindergarten_management.models.dto.WithdrawChildDto;
import kg.mega.smart_kindergarten_management.repositories.ChildRepo;
import kg.mega.smart_kindergarten_management.repositories.GroupChildrenRepo;
import kg.mega.smart_kindergarten_management.repositories.GroupRepo;
import kg.mega.smart_kindergarten_management.services.GroupChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GroupChildrenServiceImpl implements GroupChildrenService {

    private final GroupChildrenRepo groupChildrenRepo;
    private final ChildRepo childRepo;
    private final GroupRepo groupRepo;
    private final ChildMapper mapper;

    @Override
    public EnrollChildDto enroll(EnrollChildCreateDto dto) {
        Group group = groupRepo.findById(dto.getGroupId())
                .orElseThrow(() -> new NotFoundException("Группа не найдена"));

        if (!group.getGroupCategory().getActive()) {
            throw new ConflictException("Категория групп не активна");
        }

        long currentChildrenCount = groupChildrenRepo.countByGroup_IdAndEndDateIsNull(group.getId());
        if (currentChildrenCount >= group.getMaxChildrenCount()) {
            throw new ConflictException("Группа заполнена!");
        }

        boolean alreadyEnrolled = groupChildrenRepo.existsByChild_FirstNameAndChild_LastNameAndEndDateIsNull(
                dto.getFirstName(),
                dto.getLastName()
        );
        if (alreadyEnrolled) {
            throw new ConflictException("Ребенок уже зачислен в группу: " + group.getName());
        }

        Child child = childRepo.save(mapper.toEntity(dto));

        GroupChildren gc = GroupChildren.builder()
                .child(child)
                .group(group)
                .startDate(LocalDate.now())
                .price(dto.getPrice() != null ? dto.getPrice() : group.getPrice())
                .build();

        groupChildrenRepo.save(gc);

        EnrollChildDto dtoOut = mapper.toDto(child);
        dtoOut.setGroupId(group.getId());
        dtoOut.setPrice(gc.getPrice());
        return dtoOut;
    }

    @Override
    public EnrollChildDto withdraw(Long id, WithdrawChildDto dto) {
        GroupChildren gc = groupChildrenRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Запись не найдена"));

        if (gc.getEndDate() != null) {
            throw new ConflictException("Ребенок уже отчислен из группы");
        }

        LocalDate endDate = dto.getEndDate() != null ? dto.getEndDate() : LocalDate.now();

        if (endDate.isBefore(gc.getStartDate())) {
            throw new ConflictException("Дата удаления не может быть раньше даты зачисления!");
        }

        gc.setEndDate(endDate);
        groupChildrenRepo.save(gc);

        EnrollChildDto dtoOut = mapper.toDto(gc.getChild());
        dtoOut.setGroupId(gc.getGroup().getId());
        dtoOut.setPrice(gc.getPrice());
        return dtoOut;
    }

}

