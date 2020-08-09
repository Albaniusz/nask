package local.nask.sw.controller;

import local.nask.sw.dao.AllCharactersDAO;
import local.nask.sw.dao.CharacterDAO;
import local.nask.sw.dao.StarshipDAO;
import local.nask.sw.dao.WorldDAO;
import local.nask.sw.entity.Character;
import local.nask.sw.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public AllCharactersDAO charactersList(@RequestParam(name = "page", defaultValue = "0") int pageNo) {
        log.debug("Generating characters list");

        Pageable pageable = PageRequest.of(pageNo, 10);
        Page<Character> page = characterService.findPaginatedAllCharactersWithHomeworldAndStarships(pageable);

        AllCharactersDAO allCharactersDAO = new AllCharactersDAO();
        allCharactersDAO.setCount(page.getTotalElements());
        allCharactersDAO.setPages(page.getTotalPages());
        allCharactersDAO.setElements(page.stream()
                .map(this::mapCharacterData)
                .collect(toList())
        );

        return allCharactersDAO;
    }

    @GetMapping("/characters/{characterId}")
    public CharacterDAO characterDetail(@PathVariable Long characterId) throws Exception {
        log.debug("Generating character details of id: {}", characterId);

        Character character = characterService.findCharacterWithHomeworldAndShipsById(characterId);
        return mapCharacterData(character);
    }

    private CharacterDAO mapCharacterData(Character character) {
        CharacterDAO characterDAO = new CharacterDAO(character);

        characterDAO.setHomeworld(new WorldDAO(character.getHomeworld()));
        characterDAO.setStarships(character.getStarships().stream()
                .map(StarshipDAO::new)
                .collect(toList()));

        return characterDAO;
    }
}
