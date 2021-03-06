//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.1.3-b01-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2009.10.26 at 12:24:15 PM CET
//

package fr.ign.cogit.gru3d.regleUrba.reglesUrbanismes.regles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import fr.ign.cogit.geoxygene.sig3d.sample.Symbology;
import fr.ign.cogit.geoxygene.spatial.geomprim.GM_Point;
import fr.ign.cogit.gru3d.regleUrba.Executor;
import fr.ign.cogit.gru3d.regleUrba.representation.ContrainteCOSRepresentation;
import fr.ign.cogit.gru3d.regleUrba.representation.Incoherence;
import fr.ign.cogit.gru3d.regleUrba.schemageo.Batiment;
import fr.ign.cogit.gru3d.regleUrba.schemageo.Parcelle;
import fr.ign.cogit.gru3d.regleUrba.schemageo.Toit;

/**
 * 
 *        This software is released under the licence CeCILL
 * 
 *        see LICENSE.TXT
 * 
 *        see <http://www.cecill.info/ http://www.cecill.info/
 * 
 * 
 * 
 * @copyright IGN
 * 
 * @author Brasebin Mickaël
 * 
 * @version 1.0
 *
 * <p>
 * Java class for LimitationCES complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="LimitationCES">
 *   &lt;complexContent>
 *     &lt;extension base="{}Consequence">
 *       &lt;sequence>
 *         &lt;element name="cesMin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cesMax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LimitationCES", propOrder = { "cesMin", "cesMax" })
public class LimitationCES extends Consequence {

  protected double cesMin;
  protected double cesMax;

  /**
   * Gets the value of the cesMin property.
   */
  public double getCesMin() {
    return this.cesMin;
  }

  /**
   * Sets the value of the cesMin property.
   */
  public void setCesMin(double value) {
    this.cesMin = value;
  }

  /**
   * Gets the value of the cesMax property.
   */
  public double getCesMax() {
    return this.cesMax;
  }

  /**
   * Sets the value of the cesMax property.
   */
  public void setCesMax(double value) {
    this.cesMax = value;
  }

  public LimitationCES(double cesMin, double cesMax) {
    super();
    this.cesMin = cesMin;
    this.cesMax = cesMax;
  }

  public LimitationCES() {
    super();
  }

  @Override
  public String toString() {
    return "Le CES doit être compris sur la parcelle entre : " + this.cesMin
        + " et " + this.cesMax;
  }

  // On prend l'aire au sol des toits
  // venant de données Bati3D c'est ok
  // il faudrait faire une découpe pour de vraies données 3D
  @Override
  public List<Incoherence> isConsequenceChecked(Parcelle p, boolean represent) {

    List<Incoherence> lIncoherence = new ArrayList<Incoherence>();

    double aireParcelle = p.getGeom().area();
    double aireBatie = 0;
    // On parcourt la liste des batiments
    List<Batiment> lBatiments = p.getlBatimentsContenus();

    int nbBatiments = lBatiments.size();

    for (int i = 0; i < nbBatiments; i++) {

      Toit t = lBatiments.get(i).getToit();

      if (t == null) {

        System.out.println("ERROR CES : rajouter cas ou pas de toit");

        continue;
      }

      aireBatie = aireBatie + t.getGeom().area();

    }

    double CESactuel = aireBatie / aireParcelle;
    p.setCes(CESactuel);

    System.out.println("CES : " + CESactuel);

    if (CESactuel > this.cesMax) {
      if (Executor.VERBOSE) {
        System.out.println("Conséquence non vérifiée : CES Max dépassé");

      }

      
      
      if(represent){
        lIncoherence.add(new Incoherence(this, p, ContrainteCOSRepresentation
            .generateBG(new GM_Point(p.getGeom().centroid()), 15.0, Color.red,
                2.0, this.cesMin + "", CESactuel + "", this.cesMax + "", 2, 5,
                Symbology.class.getResource("/demo3D/reglesurba/cos.png")
                    .getPath())));
        ;
      }else if(! represent){
        
        lIncoherence.add(new Incoherence(this));
        return lIncoherence;
      }

    }

    if (CESactuel < this.cesMin) {
      if (Executor.VERBOSE) {
        System.out.println("Conséquence non vérifiée : CES Min non respecté");

      }
      
      if(represent){

      lIncoherence.add(new Incoherence(this, p, ContrainteCOSRepresentation
          .generateBG(new GM_Point(p.getGeom().centroid()), 15.0, Color.red,
              2.0, this.cesMin + "", CESactuel + "", this.cesMax + "", 2, 5,
              Symbology.class.getResource("/demo3D/reglesurba/cos.png")
                  .getPath())));
      }else if(represent){
        
        lIncoherence.add(new Incoherence(this));
        return lIncoherence;
      }
    }

    if (Executor.VERBOSE) {
      if (lIncoherence.size() == 0) {
        System.out.println("Conséquence vérifiée : CES");
      }
    }

    return lIncoherence;

  }
}
