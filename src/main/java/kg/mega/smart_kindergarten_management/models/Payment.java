package kg.mega.smart_kindergarten_management.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private GroupChildren groupChildren;

    private Integer amount;
    private LocalDate paymentDate;
}


