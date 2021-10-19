package dtos;

import entities.Loot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LootDTO {

    private Long id;
    private String playerName;
    private Date date;
    private String lootDescription;
    private String area;
    private boolean isRune;
    private boolean isValuable;

    public LootDTO(Loot loot) {
        if ( loot.getId() != null) {
            this.id = loot.getId();
        }
        this.playerName = loot.getPlayerName();
        this.date = loot.getDate();
        this.lootDescription = loot.getLootDescription();
        this.area = loot.getArea();
        this.isRune = loot.isRune();
        this.isValuable = loot.isValuable();
    }


    public LootDTO() {
    }

    public static List<LootDTO> toDTOs(List<Loot> entityLoot) {
        List<LootDTO> lootDTOs = new ArrayList<>();
        entityLoot.forEach(loot -> lootDTOs.add(new LootDTO(loot)));
        return lootDTOs;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLootDescription() {
        return lootDescription;
    }

    public void setLootDescription(String lootDescription) {
        this.lootDescription = lootDescription;
    }

    public boolean isRune() {
        return isRune;
    }

    public void setRune(boolean rune) {
        isRune = rune;
    }

    public boolean isValuable() {
        return isValuable;
    }

    public void setValuable(boolean valuable) {
        isValuable = valuable;
    }
}
