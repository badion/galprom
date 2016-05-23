package com.galprom.model;

import javax.persistence.*;

/**
 * Created by MonsterX on 23.05.2016.
 */


@Entity
@DiscriminatorValue(value="Grid")
public class Grid1 {

    @Column(name = "cell_w")
    private Integer cell_w;//mm

    @Column(name = "cell_h")
    private Integer cell_h;//mm

    @Column(name = "diametr")
    private Integer diametr;//micron

    @Column(name = "roll_length")
    private Integer roll_length;//sm

    @Column(name = "roll_width")
    private Integer roll_width;//sml

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Integer getCell_w() {
        return cell_w;
    }

    public void setCell_w(Integer cell_w) {
        this.cell_w = cell_w;
    }

    public Integer getCell_h() {
        return cell_h;
    }

    public void setCell_h(Integer cell_h) {
        this.cell_h = cell_h;
    }

    public Integer getDiametr() {
        return diametr;
    }

    public void setDiametr(Integer diametr) {
        this.diametr = diametr;
    }

    public Integer getRoll_length() {
        return roll_length;
    }

    public void setRoll_length(Integer roll_length) {
        this.roll_length = roll_length;
    }

    public Integer getRoll_width() {
        return roll_width;
    }

    public void setRoll_width(Integer roll_width) {
        this.roll_width = roll_width;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Grid1{" +
                "cell_w=" + cell_w +
                ", cell_h=" + cell_h +
                ", diametr=" + diametr +
                ", roll_length=" + roll_length +
                ", roll_width=" + roll_width +
                ", category=" + category +
                '}';
    }
}
