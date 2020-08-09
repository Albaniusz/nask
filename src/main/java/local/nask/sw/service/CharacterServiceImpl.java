package local.nask.sw.service;

import local.nask.sw.entity.Character;
import local.nask.sw.repository.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    @Transactional
    public Page<Character> findPaginatedAllCharactersWithHomeworldAndStarships(Pageable pageable) {
        log.debug("Finding all characters with homeworld and starships");
        return characterRepository.findPaginatedAllCharactersWithHomeworldAndStarships(pageable);
    }

    @Override
    @Transactional
    public Character findCharacterWithHomeworldAndShipsById(long characterId) throws Exception {
        log.debug("Finding character with homeworld and ship by id: {}", characterId);
        return characterRepository.findCharacterWithHomeworldAndShipsById(characterId)
                .orElseThrow(Exception::new);
    }
}
