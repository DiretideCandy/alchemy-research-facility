package ru.ct.alchemy.model.inventory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materials", schema = "research")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MaterialType type;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

}
