package kg.mega.smart_kindergarten_management.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer maxChildrenCount;
    private Integer price;

    @ManyToOne
    private Teacher nanny;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private GroupCategory groupCategory;
}


