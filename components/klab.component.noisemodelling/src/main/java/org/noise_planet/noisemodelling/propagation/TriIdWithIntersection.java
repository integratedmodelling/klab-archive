/**
 * NoiseMap is a scientific computation plugin for OrbisGIS developed in order to
 * evaluate the noise impact on urban mobility plans. This model is
 * based on the French standard method NMPB2008. It includes traffic-to-noise
 * sources evaluation and sound propagation processing.
 *
 * This version is developed at French IRSTV Institute and at IFSTTAR
 * (http://www.ifsttar.fr/) as part of the Eval-PDU project, funded by the
 * French Agence Nationale de la Recherche (ANR) under contract ANR-08-VILL-0005-01.
 *
 * Noisemap is distributed under GPL 3 license. Its reference contact is Judicaël
 * Picaut <judicael.picaut@ifsttar.fr>. It is maintained by Nicolas Fortin
 * as part of the "Atelier SIG" team of the IRSTV Institute <http://www.irstv.fr/>.
 *
 * Copyright (C) 2011 IFSTTAR
 * Copyright (C) 2011-2012 IRSTV (FR CNRS 2488)
 *
 * Noisemap is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Noisemap is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Noisemap. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.noise_planet.noisemodelling.propagation;

import org.locationtech.jts.geom.Coordinate;
/**
 * TriIdWithIntersection work for FastObstructionTest, 
 * aims to keep the interested points coordinate and check if this point in building
 * @author SU Qi
 * @author Nicolas Fortin
 */
public class TriIdWithIntersection extends Coordinate {

    private int triID;//triangle id
    private final boolean intersectionOnBuilding; //if this intersection is on building
    private final boolean intersectionOnTopography;
    private final int buildingId;

    public TriIdWithIntersection(int triID, Coordinate coorIntersection, boolean intersectionOnBuilding, boolean intersectionOnTopography, int buildingId) {
        super(coorIntersection);
        this.triID = triID;
        this.intersectionOnBuilding = intersectionOnBuilding;
        this.intersectionOnTopography = intersectionOnTopography;
        this.buildingId = buildingId;
    }

    public TriIdWithIntersection(int triID, Coordinate coorIntersection) {
        super(coorIntersection);
        this.triID = triID;
        intersectionOnBuilding = false;
        intersectionOnTopography = false;
        buildingId = 0;
    }

    public TriIdWithIntersection(TriIdWithIntersection other, Coordinate coorIntersection) {
        super(coorIntersection);
        this.triID = other.getTriID();
        this.intersectionOnBuilding = other.isIntersectionOnBuilding();
        this.intersectionOnTopography = other.isIntersectionOnTopography();
        this.buildingId = other.getBuildingId();
    }

    /**
     * @return Triangle ID
     */
    public int getTriID() {

        return this.triID;
    }

    /**
     * @return Intersection coordinate
     */
    public Coordinate getCoorIntersection() {
        return this;
    }

    public boolean isIntersectionOnBuilding() {
        return intersectionOnBuilding;
    }

    public boolean isIntersectionOnTopography() {
        return intersectionOnTopography;
    }

    /**
     * @return Building identifier 1-n (0 if none)
     */
    public int getBuildingId() {
        return buildingId;
    }
}
