package local.nask.sw.service;

import local.nask.sw.entity.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {
    Page<Character> findPaginatedAllCharactersWithHomeworldAndStarships(Pageable pageable);

    Character findCharacterWithHomeworldAndShipsById(long characterId) throws Exception;
}
