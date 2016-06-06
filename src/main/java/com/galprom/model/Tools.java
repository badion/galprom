package com.galprom.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by MonsterX on 23.05.2016.
 */

@Entity
@DiscriminatorValue(value="Tools")
public class Tools extends Product{

      @Column(name = "type")
    private String type;

    @Override
    public String toString() {
        return "Tools{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }

    public int compareTo(Grid o) {
        return 0;
    }
}
