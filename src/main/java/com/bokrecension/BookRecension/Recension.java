/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bokrecension.BookRecension;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import java.util.Objects;

/**
 *
 * @author dhambraeus
 */
@Entity
public class Recension {
    private @Id @GeneratedValue Long id;
    private String bokNamn;
    private String recensionsText;
    private String foerfattarNamn;
    
    Recension() {}
    
    Recension(String bokNamn, String recensionsText, String foerfattarNamn) {
        this.bokNamn = bokNamn;
        this.recensionsText = recensionsText;
        this.foerfattarNamn = foerfattarNamn;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public String getBokNamn() {
        return this.bokNamn;
    }
    
    public String getRecensionsText() {
        return this.recensionsText;
    }
    
    public String getFoerfattarNamn() {
        return this.foerfattarNamn;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setBokNamn(String bokNamn) {
        this.bokNamn = bokNamn;
    }
    
    public void setRecensionsText(String recensionsText) {
        this.recensionsText = recensionsText;
    }
    
    public void setFoerfattarNamn(String foerfattarNamn) {
        this.foerfattarNamn = foerfattarNamn;
    }
    
    @Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Recension))
        return false;
      Recension recension = (Recension) o;
      return Objects.equals(this.id, recension.id) 
              && Objects.equals(this.bokNamn, recension.bokNamn) 
              && Objects.equals(this.recensionsText, recension.recensionsText) 
              && Objects.equals(this.foerfattarNamn, recension.foerfattarNamn);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.bokNamn, 
              this.recensionsText, this.foerfattarNamn);
    }

    @Override
    public String toString() {
      return "Recension{" + "id=" + this.id 
              + ", bokNamn='" + this.bokNamn + '\'' + ", "
              + "recensionsText='" + this.recensionsText + '\'' 
              + ", foerfattarNamn='" + this.foerfattarNamn + '\'' + '}';
    }
}
