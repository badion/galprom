package com.galprom.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "grid")
public class Grid implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty(message = "Поле має бути не пустим")
    @Size(min = 2, max = 30, message = "Введена назва має бути від 2 до 30 символів")
    @Column(name = "name",columnDefinition = "varchar(250) character set utf8 collate utf8_general_ci")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        if (id != null ? !id.equals(grid.id) : grid.id != null) return false;
        if (name != null ? !name.equals(grid.name) : grid.name != null) return false;
        if (cell_w != null ? !cell_w.equals(grid.cell_w) : grid.cell_w != null) return false;
        if (cell_h != null ? !cell_h.equals(grid.cell_h) : grid.cell_h != null) return false;
        if (diametr != null ? !diametr.equals(grid.diametr) : grid.diametr != null) return false;
        if (roll_length != null ? !roll_length.equals(grid.roll_length) : grid.roll_length != null) return false;
        if (roll_width != null ? !roll_width.equals(grid.roll_width) : grid.roll_width != null) return false;
        if (price != null ? !price.equals(grid.price) : grid.price != null) return false;
        return category != null ? category.equals(grid.category) : grid.category == null;

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
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
            return "Grid{" +
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

}
