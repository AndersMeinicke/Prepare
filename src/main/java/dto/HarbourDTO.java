package dto;

import entities.Harbour;
import entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HarbourDTO implements Serializable {
    private String name;
    private String adress;
    private int capacity;

    public HarbourDTO(String name, String adress, int capacity) {
        this.name = name;
        this.adress = adress;
        this.capacity = capacity;
    }
    public HarbourDTO(Harbour harbour){
        this.name = harbour.getName();
        this.adress = harbour.getAdress();
        this.capacity = harbour.getCapacity();
    }

    public static List<HarbourDTO> getHarbourDTOs(List<Harbour> harbours) {
        List<HarbourDTO> harbourDTOList = new ArrayList<>();
        harbours.forEach(harbour -> {
            harbourDTOList.add(new HarbourDTO(harbour));
        });
        return harbourDTOList;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarbourDTO entity = (HarbourDTO) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.adress, entity.adress) &&
                Objects.equals(this.capacity, entity.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adress, capacity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "adress = " + adress + ", " +
                "capacity = " + capacity + ")";
    }
}
