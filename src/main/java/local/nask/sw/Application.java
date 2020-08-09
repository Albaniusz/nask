package local.nask.sw;

import local.nask.sw.entity.Character;
import local.nask.sw.entity.Starship;
import local.nask.sw.entity.World;
import local.nask.sw.repository.CharacterRepository;
import local.nask.sw.repository.StarshipRepository;
import local.nask.sw.repository.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private StarshipRepository starshipRepository;

    @Autowired
    private WorldRepository worldRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        initData();
    }

    private void initData() {

        World tatooineWorld = new World();

        tatooineWorld.setName("Tatooine");
        tatooineWorld.setRotationPeriod(23);
        tatooineWorld.setOrbitalPeriod(304);
        tatooineWorld.setDiameter(10465);
        tatooineWorld.setClimate("arid");//FIXME enum
        tatooineWorld.setGravity("1 standard");
        tatooineWorld.setTerrain("desert");//FIXME enum
        tatooineWorld.setSurfaceWater(1);
        tatooineWorld.setPopulation(200000);

        worldRepository.save(tatooineWorld);


        Starship xWingStarship = new Starship();

        xWingStarship.setName("X-wing");
        xWingStarship.setModel("T-65 X-wing");
        xWingStarship.setManufacturer("Incom Corporation");//FIXME relation/enum
        xWingStarship.setCostInCredits(149999);
        xWingStarship.setLength(12.5);
        xWingStarship.setMaxAtmosphericSpeed(1050);
        xWingStarship.setCrew(1);
        xWingStarship.setPassengers(0);
        xWingStarship.setCargoCapacity(110);
        xWingStarship.setConsumables("1 week");
        xWingStarship.setHyperdriveRating(1.0);
        xWingStarship.setMglt(100);
        xWingStarship.setStarshipClass("Starfighter");//FIXME enum

        starshipRepository.save(xWingStarship);

        Starship imperialShuttleStarship = new Starship();

        imperialShuttleStarship.setName("Imperial shuttle");
        imperialShuttleStarship.setModel("Lambda-class T-4a shuttle");
        imperialShuttleStarship.setManufacturer("Sienar Fleet Systems");
        imperialShuttleStarship.setCostInCredits(240000);
        imperialShuttleStarship.setLength(20);
        imperialShuttleStarship.setMaxAtmosphericSpeed(850);
        imperialShuttleStarship.setCrew(6);
        imperialShuttleStarship.setPassengers(20);
        imperialShuttleStarship.setCargoCapacity(80000);
        imperialShuttleStarship.setConsumables("2 months");
        imperialShuttleStarship.setHyperdriveRating(1.0);
        imperialShuttleStarship.setMglt(50);
        imperialShuttleStarship.setStarshipClass("Armed government transport");//FIXME enum

        starshipRepository.save(imperialShuttleStarship);


        Character lukeSkywalkerCharacter = new Character();

        lukeSkywalkerCharacter.setName("Luke Skywalker");
        lukeSkywalkerCharacter.setHeight(172);
        lukeSkywalkerCharacter.setMass(77);
        lukeSkywalkerCharacter.setHairColor("blond");//FIXME enum
        lukeSkywalkerCharacter.setSkinColor("fair");//FIXME enum
        lukeSkywalkerCharacter.setEyeColor("blue");//FIXME enum
        lukeSkywalkerCharacter.setBirthYear("19BBY");
        lukeSkywalkerCharacter.setGender("male");//FIXME enum
        lukeSkywalkerCharacter.setHomeworld(tatooineWorld);

        lukeSkywalkerCharacter.addStarship(xWingStarship);
        lukeSkywalkerCharacter.addStarship(imperialShuttleStarship);

        characterRepository.save(lukeSkywalkerCharacter);
    }
}
