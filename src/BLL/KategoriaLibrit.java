/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Kategoria_Librit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KategoriaLibrit.findAll", query = "SELECT k FROM KategoriaLibrit k"),
    @NamedQuery(name = "KategoriaLibrit.findByKategoriaId", query = "SELECT k FROM KategoriaLibrit k WHERE k.kategoriaId = :kategoriaId"),
    @NamedQuery(name = "KategoriaLibrit.findByKLEmri", query = "SELECT k FROM KategoriaLibrit k WHERE k.kLEmri = :kLEmri"),
    @NamedQuery(name = "KategoriaLibrit.findByKLSasia", query = "SELECT k FROM KategoriaLibrit k WHERE k.kLSasia = :kLSasia")})
public class KategoriaLibrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Kategoria_Id")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ",allocationSize=1)
    private Integer kategoriaId;
    @Basic(optional = false)
    @Column(name = "KL_Emri")
    private String kLEmri;
    @Basic(optional = false)
    @Column(name = "KL_Sasia")
    private String kLSasia;
    @OneToMany(mappedBy = "lKategoriaId")
    private Collection<Libri> libriCollection;

    public KategoriaLibrit() {}

    public KategoriaLibrit(Integer kategoriaId) {
        this.kategoriaId = kategoriaId;
    }

    public KategoriaLibrit(Integer kategoriaId, String kLEmri, String kLSasia) {
        this.kategoriaId = kategoriaId;
        this.kLEmri = kLEmri;
        this.kLSasia = kLSasia;
    }

    public Integer getKategoriaId() {
        return kategoriaId;
    }

    public void setKategoriaId(Integer kategoriaId) {
        this.kategoriaId = kategoriaId;
    }

    public String getKLEmri() {
        return kLEmri;
    }

    public void setKLEmri(String kLEmri) {
        this.kLEmri = kLEmri;
    }

    public String getKLSasia() {
        return kLSasia;
    }

    public void setKLSasia(String kLSasia) {
        this.kLSasia = kLSasia;
    }

    @XmlTransient
    public Collection<Libri> getLibriCollection() {
        return libriCollection;
    }

    public void setLibriCollection(Collection<Libri> libriCollection) {
        this.libriCollection = libriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriaId != null ? kategoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KategoriaLibrit)) {
            return false;
        }
        KategoriaLibrit other = (KategoriaLibrit) object;
        if ((this.kategoriaId == null && other.kategoriaId != null) || (this.kategoriaId != null && !this.kategoriaId.equals(other.kategoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.kLEmri;
    }
    
}
