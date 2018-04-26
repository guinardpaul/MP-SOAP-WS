/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guinardsolutions.mp.entities.enums;

/**
 *
 * @author Paul
 */
public enum TRIMESTRE {
    TRIMESTRE1("Trimestre 1"),
    TRIMESTRE2("Trimestre 2"),
    TRIMESTRE3("Trimestre 3");

    /**
     * The name.
     */
    private final String name;

    /**
     * Instantiates a new cycle.
     *
     * @param name the name
     */
    private TRIMESTRE(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
