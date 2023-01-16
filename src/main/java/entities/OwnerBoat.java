package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "owner_boat")
public class OwnerBoat {
    @EmbeddedId
    private OwnerBoatId id;

    @MapsId("ownerID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner ownerID;

    @MapsId("boatID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "boat_id", nullable = false)
    private Boat boatID;

    public OwnerBoatId getId() {
        return id;
    }

    public void setId(OwnerBoatId id) {
        this.id = id;
    }

    public Owner getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Owner ownerID) {
        this.ownerID = ownerID;
    }

    public Boat getBoatID() {
        return boatID;
    }

    public void setBoatID(Boat boatID) {
        this.boatID = boatID;
    }

}

