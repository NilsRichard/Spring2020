package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Entity
public class ColoredTagKB extends TagKB implements Serializable {

    private static final long serialVersionUID = 5643097672571867287L;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
