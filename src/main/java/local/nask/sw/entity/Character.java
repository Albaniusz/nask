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
public class Character extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "character_generator")
    @SequenceGenerator(name = "character_generator", sequenceName = "character_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private int height;

    private int mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World homeworld;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "character_starship",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id")
    )
    private Set<Starship> starships = new HashSet<>();

    public void addStarship(Starship starship) {
        starships.add(starship);
        starship.getCharacters().add(this);
    }

    public void removeStarship(Starship starship) {
        if (starship != null) {
            starship.getCharacters().remove(this);
        }
        starships.remove(starship);
    }
}
