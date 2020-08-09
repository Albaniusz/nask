package local.nask.sw.dao;

import local.nask.sw.entity.World;
import lombok.Data;

@Data
public class WorldDAO {
    private String name;

    private int rotationPeriod;

    private int orbitalPeriod;

    private int diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private int surfaceWater;

    private int population;

    public WorldDAO(World world) {
        name = world.getName();
        rotationPeriod = world.getRotationPeriod();
        orbitalPeriod = world.getOrbitalPeriod();
        diameter = world.getDiameter();
        climate = world.getClimate();
        gravity = world.getGravity();
        terrain = world.getTerrain();
        surfaceWater = world.getSurfaceWater();
        population = world.getPopulation();
    }
}
