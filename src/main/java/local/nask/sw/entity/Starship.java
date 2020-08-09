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
public class Starship extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "starship_generator")
    @SequenceGenerator(name = "starship_generator", sequenceName = "starship_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private String model;

    private String manufacturer;

    private int costInCredits;

    private double length;

    private int maxAtmosphericSpeed;

    private int crew;

    private int passengers;

    private int cargoCapacity;

    private String consumables;

    private double hyperdriveRating;

    private int mglt;

    private String starshipClass;

    @ManyToMany(mappedBy = "starships")
    private Set<Character> characters = new HashSet<>();
}
