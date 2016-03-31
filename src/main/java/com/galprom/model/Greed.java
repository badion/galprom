package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "greed")
public class Greed implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;

    @Column(name = "cell_w", columnDefinition = "int")
    private Integer cell_w;//mm

    @Column(name = "cell_h", columnDefinition = "int")
    private Integer cell_h;//mm

    @Column(name = "diametr", columnDefinition = "int")
    private Integer diametr;//micron

    @Column(name = "roll_length", columnDefinition = "int")
    private Integer roll_length;//sm

    @Column(name = "roll_width", columnDefinition = "int")
    private Integer roll_width;//sm

    @Column(name = "price", columnDefinition = "int")
    private Integer price;//UAH
}
