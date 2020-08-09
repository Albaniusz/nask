package local.nask.sw.dao;

import local.nask.sw.entity.Character;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterDAO {
    private Long id;

    private String name;

    private int height;

    private int mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;

    private String gender;

    private WorldDAO homeworld;

    private List<StarshipDAO> starships = new ArrayList<>();

    public CharacterDAO(Character character) {
        id = character.getId();
        name = character.getName();
        height = character.getHeight();
        mass = character.getMass();
        hairColor = character.getHairColor();
        skinColor = character.getSkinColor();
        eyeColor = character.getEyeColor();
        birthYear = character.getBirthYear();
        gender = character.getGender();
    }
}
