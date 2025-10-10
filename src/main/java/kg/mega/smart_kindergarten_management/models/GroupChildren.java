package kg.mega.smart_kindergarten_management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "group_childrens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupChildren {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Child child;

    @ManyToOne
    private Group group;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
}

