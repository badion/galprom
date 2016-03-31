package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "greed")
public class Greed implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cell_w")
    private Integer cell_w;//mm

    @Column(name = "cell_h")
    private Integer cell_h;//mm

    @Column(name = "diametr")
    private Integer diametr;//micron

    @Column(name = "roll_length")
    private Integer roll_length;//sm

    @Column(name = "roll_width")
    private Integer roll_width;//sm

    @Column(name = "price")
    private Double price;//UAH

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCell_w(Integer cell_w) {
        this.cell_w = cell_w;
    }

    public void setCell_h(Integer cell_h) {
        this.cell_h = cell_h;
    }

    public void setDiametr(Integer diametr) {
        this.diametr = diametr;
    }

    public void setRoll_length(Integer roll_length) {
        this.roll_length = roll_length;
    }

    public void setRoll_width(Integer roll_width) {
        this.roll_width = roll_width;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCell_w() {
        return cell_w;
    }

    public Integer getCell_h() {
        return cell_h;
    }

    public Integer getDiametr() {
        return diametr;
    }

    public Integer getRoll_length() {
        return roll_length;
    }

    public Integer getRoll_width() {
        return roll_width;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Greed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cell_w=" + cell_w +
                ", cell_h=" + cell_h +
                ", diametr=" + diametr +
                ", roll_length=" + roll_length +
                ", roll_width=" + roll_width +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greed greed = (Greed) o;

        if (id != null ? !id.equals(greed.id) : greed.id != null) return false;
        if (name != null ? !name.equals(greed.name) : greed.name != null) return false;
        if (cell_w != null ? !cell_w.equals(greed.cell_w) : greed.cell_w != null) return false;
        if (cell_h != null ? !cell_h.equals(greed.cell_h) : greed.cell_h != null) return false;
        if (diametr != null ? !diametr.equals(greed.diametr) : greed.diametr != null) return false;
        if (roll_length != null ? !roll_length.equals(greed.roll_length) : greed.roll_length != null) return false;
        if (roll_width != null ? !roll_width.equals(greed.roll_width) : greed.roll_width != null) return false;
        return price != null ? price.equals(greed.price) : greed.price == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cell_w != null ? cell_w.hashCode() : 0);
        result = 31 * result + (cell_h != null ? cell_h.hashCode() : 0);
        result = 31 * result + (diametr != null ? diametr.hashCode() : 0);
        result = 31 * result + (roll_length != null ? roll_length.hashCode() : 0);
        result = 31 * result + (roll_width != null ? roll_width.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
