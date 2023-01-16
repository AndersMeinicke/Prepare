package utils;

import entities.Harbour;
import facades.HarbourFacade;
import facades.UserFacade;

import javax.persistence.EntityManagerFactory;

public class Populator {
    public static void main(String[] args) {
        populate();
    }
public static void populate(){
    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    HarbourFacade harbourFacade = HarbourFacade.getHarbourFacade(emf);
    harbourFacade.createHarbour(new Harbour("Local Harbour", "Copenhagen",20));
}
}
