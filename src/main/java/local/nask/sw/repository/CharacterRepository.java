package local.nask.sw.repository;

import local.nask.sw.entity.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query(value = "SELECT ch FROM Character ch " +
            "JOIN FETCH ch.homeworld " +
            "JOIN FETCH ch.starships",
            countQuery = "SELECT COUNT(ch.id) FROM Character ch")
    Page<Character> findPaginatedAllCharactersWithHomeworldAndStarships(Pageable pageable);

    @Query("SELECT ch FROM Character ch " +
            "JOIN FETCH ch.homeworld " +
            "JOIN FETCH ch.starships " +
            "WHERE ch.id = :characterId")
    Optional<Character> findCharacterWithHomeworldAndShipsById(@Param("characterId") long characterId);
}
