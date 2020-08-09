package local.nask.sw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class World extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "world_generator")
    @SequenceGenerator(name = "world_generator", sequenceName = "world_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private int rotationPeriod;

    private int orbitalPeriod;

    private int diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private int surfaceWater;

    private int population;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "homeworld")
    private Set<Character> characters = new HashSet<>();
}
