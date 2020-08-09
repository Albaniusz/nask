package local.nask.sw.dao;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllCharactersDAO {
    private long count;

    private int pages;

    private List<CharacterDAO> elements = new ArrayList<>();
}
