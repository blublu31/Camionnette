package fr.limayrac.Camionnette.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camionnette")
public class Camionnette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "modele", length = 50)
    private String modele;

    @Column(name = "marque", length = 50)
    private String marque;

    @Column(name = "carburant", length = 50)
    private String carburant;

    @Column(name = "hauteur", length = 50)
    private String hauteur;

    @OneToMany(mappedBy = "camionnette")
    private List<Location> locations = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Camionnette [id=" + id + ", modele=" + modele + ", marque=" + marque + ", email=" + carburant +", locations=" + locations + "]";
    }

}
