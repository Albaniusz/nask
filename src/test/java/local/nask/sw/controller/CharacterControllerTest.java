package local.nask.sw.controller;

import local.nask.sw.dao.CharacterDAO;
import local.nask.sw.entity.Character;
import local.nask.sw.entity.Starship;
import local.nask.sw.entity.World;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CharacterControllerTest {
//    @Mock
//    private CharacterRepository characterRepository;
//    @InjectMocks
//    private CharacterService characterService;//= new CharacterServiceImpl(characterRepository);

//    charactersList

//    schould get two element list without page number
//
//    schould get two element list on page 2
//
//    schould get empty list

//    @Test
//    public void characterDetail_schouldFoundCharacter() throws Exception {
//        // given
//        long characterId = 1;
//
//        when(characterRepository.findCharacterWithHomeworldAndShipsById(characterId))
//                .thenReturn(Optional.of(configureLukeSkywalkerCharacter()));
//
//        CharacterController characterController = new CharacterController(characterService);
////        CharacterController characterController = new CharacterController(new CharacterServiceImpl(characterRepository));
//
//        // when
//        CharacterDAO characterDAO = characterController.characterDetail(characterId);
//
//        // then
//        assertEquals(configureLukeSkywalkerCharacterDAO(), characterDAO);


//        // given // when // then
//        mockMvc.perform(get("/characters/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("{\"value\":3.0}")));
//}
//
//    @Test
//    @Disabled
//    public void characterDetail_SchouldNotFoundCharacter() throws Exception {
//        // given // when // then
//        mockMvc.perform(get("/characters/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("{\"value\":3.0}")));
//    }

    //    private MockHttpServletRequestBuilder configureGETBuilder(String urlTemplate, String value1, String value2) {
//        return get(urlTemplate)
//                .param("val1", value1)
//                .param("val2", value2);
//    }
    private Character configureLukeSkywalkerCharacter() {
        Character character = new Character();

        character.setId(1L);
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHairColor("blond");
        character.setSkinColor("fair");
        character.setEyeColor("blue");
        character.setBirthYear("19BBY");
        character.setGender("male");
        character.setHomeworld(configureTatooineWorld());

        character.getStarships().add(configureXWingStarship());
        character.getStarships().add(configureImperialShuttleStarship());

        return character;
    }

    private World configureTatooineWorld() {
        World world = new World();

        world.setId(1L);
        world.setName("Tatooine");
        world.setRotationPeriod(23);
        world.setOrbitalPeriod(304);
        world.setDiameter(10465);
        world.setClimate("arid");
        world.setGravity("1 standard");
        world.setTerrain("desert");
        world.setSurfaceWater(1);
        world.setPopulation(200000);

        return world;
    }

    private Starship configureXWingStarship() {
        Starship starship = new Starship();

        starship.setId(1L);
        starship.setName("X-wing");
        starship.setModel("T-65 X-wing");
        starship.setManufacturer("Incom Corporation");
        starship.setCostInCredits(149999);
        starship.setLength(12.5);
        starship.setMaxAtmosphericSpeed(1050);
        starship.setCrew(1);
        starship.setPassengers(0);
        starship.setCargoCapacity(110);
        starship.setConsumables("1 week");
        starship.setHyperdriveRating(1.0);
        starship.setMglt(100);
        starship.setStarshipClass("Starfighter");

        return starship;
    }

    private Starship configureImperialShuttleStarship() {
        Starship starship = new Starship();

        starship.setId(2L);
        starship.setName("Imperial shuttle");
        starship.setModel("Lambda-class T-4a shuttle");
        starship.setManufacturer("Sienar Fleet Systems");
        starship.setCostInCredits(240000);
        starship.setLength(20);
        starship.setMaxAtmosphericSpeed(850);
        starship.setCrew(6);
        starship.setPassengers(20);
        starship.setCargoCapacity(80000);
        starship.setConsumables("2 months");
        starship.setHyperdriveRating(1.0);
        starship.setMglt(50);
        starship.setStarshipClass("Armed government transport");

        return starship;
    }

    private CharacterDAO configureLukeSkywalkerCharacterDAO() {
        Character character = configureLukeSkywalkerCharacter();

        CharacterDAO characterDAO = new CharacterDAO(character);


        return characterDAO;
    }
}