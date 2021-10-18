package entities;

import dtos.LootDTO;

import javax.persistence.*;
import java.util.Date;

@Table(name = "loot")
@Entity
@NamedQuery(name = "Loot.deleteAllRows", query = "DELETE from Loot")
public class Loot {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private Date date;
    private String lootDescription;
    private boolean isRune;
    private boolean isValuable;

    public Loot() {
    }

    public Loot(LootDTO lootDTO) {
        if(lootDTO.getId() != null){
            this.id = lootDTO.getId();
        }
        this.playerName = lootDTO.getPlayerName();
        this.date = lootDTO.getDate();
        this.lootDescription = lootDTO.getLootDescription();
        this.isRune = lootDTO.isRune();
        this.isValuable = lootDTO.isValuable();
    }

    public Loot(String playerName, Date date, String lootDescription, boolean isRune, boolean isValuable) {
        this.playerName = playerName;
        this.date = date;
        this.lootDescription = lootDescription;
        this.isRune = isRune;
        this.isValuable = isValuable;
    }

    public LootDTO toDTO(Loot loot){
        return new LootDTO(loot);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}