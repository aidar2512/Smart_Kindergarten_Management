package kg.mega.smart_kindergarten_management.services.impl;

import kg.mega.smart_kindergarten_management.mappers.GroupCategoryMapper;
import kg.mega.smart_kindergarten_management.models.GroupCategory;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.GroupCategoryDto;
import kg.mega.smart_kindergarten_management.repositories.GroupCategoryRepo;
import kg.mega.smart_kindergarten_management.services.GroupCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupCategoryServiceImpl implements GroupCategoryService {

    private final GroupCategoryRepo repository;
    private final GroupCategoryMapper mapper;

    @Override
    public GroupCategoryDto create(GroupCategoryCreateDto dto) {
        if (repository.existsByNameIgnoreCase(dto.getName())) {
            throw new ConflictException("Категория с таким названием уже существует");
        }
        GroupCategory entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public GroupCategoryDto update(Long id, GroupCategoryCreateDto dto) {
        GroupCategory existing = repository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Категория не найдена"));

        if (!existing.getName().equalsIgnoreCase(dto.getName())
                && repository.existsByNameIgnoreCase(dto.getName())) {
            throw new ConflictException("Категория с таким названием уже существует");
        }

        existing.setName(dto.getName());
        existing.setActive(dto.getActive());
        existing.setPrice(dto.getPrice());

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Категория не найдена");
        }
        repository.deleteById(id);
    }

    @Override
    public GroupCategoryDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Категория не найдена"));
    }

    @Override
    public Page<GroupCategoryDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
