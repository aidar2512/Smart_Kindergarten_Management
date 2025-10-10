package kg.mega.smart_kindergarten_management.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Integer price;
}
