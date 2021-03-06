//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.1.3-b01-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2009.10.26 at 12:24:15 PM CET
//

package fr.ign.cogit.gru3d.regleUrba.reglesUrbanismes.regles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import fr.ign.cogit.gru3d.regleUrba.Executor;
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
 * Java class for TypeBatiment complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;TypeBatiment&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{}Antecedent&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;nomTypes&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;nomTextures&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeBatiment", propOrder = { "nomTypes", "nomTextures" })
public class TypeBatiment extends Antecedent {

  public void setNomTypes(List<String> nomTypes) {
    this.nomTypes = nomTypes;
  }

  public void setNomTextures(List<String> nomTextures) {
    this.nomTextures = nomTextures;
  }

  public TypeBatiment() {
  }

  public TypeBatiment(List<String> nomTypes, List<String> nomTextures) {
    this.nomTypes = nomTypes;
    this.nomTextures = nomTextures;
  }

  @XmlElement(required = true)
  protected List<String> nomTypes;
  @XmlElement(required = true)
  protected List<String> nomTextures;

  private static String[] lNomsTypes = { "Constructions techniques (VRD)",
      "Construction à vocation de protection de l'environnement",
      "Construction pour activités industrielles",
      "Construction pour activités commerciales",
      "Construction à destination d'habitation",
      "Construction à destination d'enseignement",
      "Construction à destination de santé",
      "Construction à destination de bureaux",
      "Construction à destination de loisirs"

  };

  public static String[] getLNomsTypes() {
    return TypeBatiment.lNomsTypes;

  }

  /**
   * Gets the value of the nomTypes property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the nomTypes property.
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getNomTypes().add(newItem);
   * </pre>
   * <p>
   * Objects of the following type(s) are allowed in the list {@link String }
   */
  public List<String> getNomTypes() {
    if (this.nomTypes == null) {
      this.nomTypes = new ArrayList<String>();
    }
    return this.nomTypes;
  }

  /**
   * Gets the value of the nomTextures property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
   * for the nomTextures property.
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getNomTextures().add(newItem);
   * </pre>
   * <p>
   * Objects of the following type(s) are allowed in the list {@link String }
   */
  public List<String> getNomTextures() {
    if (this.nomTextures == null) {
      this.nomTextures = new ArrayList<String>();
    }
    return this.nomTextures;
  }

  @Override
  public String toString() {

    int nbTypes = this.getNomTypes().size();
    int nbTextures = this.getNomTextures().size();

    if (nbTypes + nbTextures == 0) {

      return "La règle s'appliquera à tous les bâtiments ";
    }

    String s = "La règle s'appliquera aux bâtiments";

    if (nbTextures != 0) {
      s = s + "\n - possédant les textures :\n";

    }

    for (int i = 0; i < nbTextures; i++) {

      s = s + this.nomTextures.get(i);

      if (i == nbTextures - 2) {
        s = s + "\n";

      } else if (i == nbTextures - 1) {

        s = s + "";
      } else {
        s = s + ",\n";

      }

    }

    if (nbTypes != 0) {
      s = s + "\n - du type :\n";

    }

    for (int i = 0; i < nbTypes; i++) {

      s = s + this.nomTypes.get(i);

      if (i == nbTypes - 2) {
        s = s + "\n";

      } else if (i == nbTypes - 1) {

        s = s + "";
      } else {
        s = s + ",\n";

      }

    }

    // TODO Auto-generated method stub
    return s;
  }

  // Renvoie true si le type d'un des batiments de la parcelle corrrespond
  // A un type proposé
  // A une texture proposée

  @Override
  public boolean isAntecedantChecked(Parcelle p) {
    List<Batiment> lBatiments = p.getlBatimentsContenus();

    int nbBatiments = lBatiments.size();
    int nbTypes = this.getNomTypes().size();
    int nbTexture = this.getNomTextures().size();

    for (int i = 0; i < nbBatiments; i++) {
      Batiment b = lBatiments.get(i);

      // On teste le type du batiment
      for (int j = 0; j < nbTypes; j++) {
        if (b.getType().equalsIgnoreCase(this.getNomTypes().get(j))) {

          if (Executor.VERBOSE) {
            System.out.println("Condition vérifiée : type batiment");

          }

          return true;

        }

      }

      // On teste la texture du batiment
      for (int j = 0; j < nbTexture; j++) {
        if (b.getTexture().getNom()
            .equalsIgnoreCase(this.getNomTextures().get(j))) {

          if (Executor.VERBOSE) {
            System.out.println("Condition vérifiée : texture  batiment");

          }

          return true;

        }

      }

      // On teste la texture du toit du batiment
      Toit t = b.getToit();
      if (t == null) {

        continue;
      }
      for (int j = 0; j < nbTexture; j++) {
        if (t.getTexture().getNom()
            .equalsIgnoreCase(this.getNomTextures().get(j))) {

          if (Executor.VERBOSE) {
            System.out.println("Condition vérifiée : texture toit");

          }

          return true;

        }

      }
    }

    return false;
  }

}
