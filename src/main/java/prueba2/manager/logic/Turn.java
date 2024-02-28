/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2.manager.logic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Manak
 */
@Entity
@Table(name = "turn", catalog = "managerdb", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id" }) })
@NamedQueries({
        @NamedQuery(name = "Turn.findAll", query = "SELECT t FROM Turn t"),
        @NamedQuery(name = "Turn.findById", query = "SELECT t FROM Turn t WHERE t.id = :id"),
        @NamedQuery(name = "Turn.findByNumber", query = "SELECT t FROM Turn t WHERE t.number = :number"),
        @NamedQuery(name = "Turn.findByDate", query = "SELECT t FROM Turn t WHERE t.onDate = :onDate"),
        @NamedQuery(name = "Turn.findByDescription", query = "SELECT t FROM Turn t WHERE t.description = :description"),
        @NamedQuery(name = "Turn.findByDone", query = "SELECT t FROM Turn t WHERE t.done = :done"),
        @NamedQuery(name = "Turn.findByPersonId", query = "SELECT t FROM Turn t WHERE t.personId = :personId") })
public class Turn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number", nullable = false)
    private long number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date onDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "done", nullable = false)
    private boolean done;
    @Basic(optional = false)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person personId;

    public Turn() {
    }

    public Turn(long number, Date onDate, String description, boolean done, Person personId) {
        this.number = number;
        this.onDate = onDate;
        this.description = description;
        this.done = done;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Turn)) {
            return false;
        }
        Turn other = (Turn) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "prueba2.manager.logic.Turn[ id=" + id + " ]";
    }

}
