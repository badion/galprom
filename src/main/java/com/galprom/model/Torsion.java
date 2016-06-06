package com.galprom.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by MonsterX on 23.05.2016.
 */


@Entity
@DiscriminatorValue(value="Torsion")
public class Torsion extends Product {

    @Column(name = "code_left")
    private String code_left;

    @Column(name = "code_right")
    private String code_right;

    public String getCode_left() {
        return code_left;
    }

    public void setCode_left(String code_left) {
        this.code_left = code_left;
    }

    public String getCode_right() {
        return code_right;
    }

    public void setCode_right(String code_right) {
        this.code_right = code_right;
    }

    @Override
    public String toString() {
        return "Torsion{" +
                "code_left='" + code_left + '\'' +
                ", code_right='" + code_right + '\'' +
                "} " + super.toString();
    }

    public int compareTo(Grid o) {
        return 0;
    }
}
