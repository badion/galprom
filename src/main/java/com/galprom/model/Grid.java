package com.galprom.model;

import javax.persistence.*;

/**
 * Created by MonsterX on 23.05.2016.
 */


@Entity
@DiscriminatorValue(value="Grid")
public class Grid extends Product{

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

}
