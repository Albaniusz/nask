package local.nask.sw.dao;

import local.nask.sw.entity.Starship;
import lombok.Data;

@Data
public class StarshipDAO {
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

    public StarshipDAO(Starship starship) {
        name = starship.getName();
        model = starship.getModel();
        manufacturer = starship.getManufacturer();
        costInCredits = starship.getCostInCredits();
        length = starship.getLength();
        maxAtmosphericSpeed = starship.getMaxAtmosphericSpeed();
        crew = starship.getCrew();
        passengers = starship.getPassengers();
        cargoCapacity = starship.getCargoCapacity();
        consumables = starship.getConsumables();
        hyperdriveRating = starship.getHyperdriveRating();
        mglt = starship.getMglt();
        starshipClass = starship.getStarshipClass();
    }
}
