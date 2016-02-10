package com.netcracker.databasemodul.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "competition", catalog = "test_system", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competition.findAll", query = "SELECT c FROM Competition c"),
    @NamedQuery(name = "Competition.findById", query = "SELECT c FROM Competition c WHERE c.id = :id"),
    @NamedQuery(name = "Competition.findByName", query = "SELECT c FROM Competition c WHERE c.name = :name"),
    @NamedQuery(name = "Competition.findByHoldCompetition", query = "SELECT c FROM Competition c WHERE c.holdCompetition = :holdCompetition"),
    @NamedQuery(name = "Competition.findByEvaluationType", query = "SELECT c FROM Competition c WHERE c.evaluationType = :evaluationType"),
    @NamedQuery(name = "Competition.findByRegistrationType", query = "SELECT c FROM Competition c WHERE c.registrationType = :registrationType"),
    @NamedQuery(name = "Competition.findByVisible", query = "SELECT c FROM Competition c WHERE c.visible = :visible"),
    @NamedQuery(name = "Competition.findByShowMonitor", query = "SELECT c FROM Competition c WHERE c.showMonitor = :showMonitor"),
    @NamedQuery(name = "Competition.findByPretestsOnly", query = "SELECT c FROM Competition c WHERE c.pretestsOnly = :pretestsOnly"),
    @NamedQuery(name = "Competition.findByPracticePermition", query = "SELECT c FROM Competition c WHERE c.practicePermition = :practicePermition"),
    @NamedQuery(name = "Competition.findByFinished", query = "SELECT c FROM Competition c WHERE c.finished = :finished"),
    @NamedQuery(name = "Competition.findByFolderName", query = "SELECT c FROM Competition c WHERE c.folderName = :folderName"),
    @NamedQuery(name = "Competition.findByCompetitionStart", query = "SELECT c FROM Competition c WHERE c.competitionStart = :competitionStart")})
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "hold_competition")
    private boolean holdCompetition;
    @Basic(optional = false)
    @Column(name = "evaluation_type")
    private String evaluationType;
    @Basic(optional = false)
    @Column(name = "registration_type")
    private String registrationType;
    @Basic(optional = false)
    @Column(name = "visible")
    private boolean visible;
    @Basic(optional = false)
    @Column(name = "show_monitor")
    private boolean showMonitor;
    @Basic(optional = false)
    @Column(name = "pretests_only")
    private boolean pretestsOnly;
    @Basic(optional = false)
    @Column(name = "practice_permition")
    private boolean practicePermition;
    @Basic(optional = false)
    @Column(name = "finished")
    private boolean finished;
    @Basic(optional = false)
    @Column(name = "folder_name")
    private String folderName;
    @Column(name = "competition_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date competitionStart;
    @Lob
    @Column(name = "competition_interval")
    private Object competitionInterval;
    @Lob
    @Column(name = "interval_before_frozen")
    private Object intervalBeforeFrozen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competitionId")
    private List<CompetitionProblem> competitionProblemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competitionId")
    private List<Participation> participationList;

    public Competition() {
    }

    public Competition(Integer id) {
        this.id = id;
    }

    public Competition(Integer id, String name, boolean holdCompetition, String evaluationType, String registrationType, boolean visible, boolean showMonitor, boolean pretestsOnly, boolean practicePermition, boolean finished, String folderName) {
        this.id = id;
        this.name = name;
        this.holdCompetition = holdCompetition;
        this.evaluationType = evaluationType;
        this.registrationType = registrationType;
        this.visible = visible;
        this.showMonitor = showMonitor;
        this.pretestsOnly = pretestsOnly;
        this.practicePermition = practicePermition;
        this.finished = finished;
        this.folderName = folderName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getHoldCompetition() {
        return holdCompetition;
    }

    public void setHoldCompetition(boolean holdCompetition) {
        this.holdCompetition = holdCompetition;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getShowMonitor() {
        return showMonitor;
    }

    public void setShowMonitor(boolean showMonitor) {
        this.showMonitor = showMonitor;
    }

    public boolean getPretestsOnly() {
        return pretestsOnly;
    }

    public void setPretestsOnly(boolean pretestsOnly) {
        this.pretestsOnly = pretestsOnly;
    }

    public boolean getPracticePermition() {
        return practicePermition;
    }

    public void setPracticePermition(boolean practicePermition) {
        this.practicePermition = practicePermition;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Date getCompetitionStart() {
        return competitionStart;
    }

    public void setCompetitionStart(Date competitionStart) {
        this.competitionStart = competitionStart;
    }

    public Object getCompetitionInterval() {
        return competitionInterval;
    }

    public void setCompetitionInterval(Object competitionInterval) {
        this.competitionInterval = competitionInterval;
    }

    public Object getIntervalBeforeFrozen() {
        return intervalBeforeFrozen;
    }

    public void setIntervalBeforeFrozen(Object intervalBeforeFrozen) {
        this.intervalBeforeFrozen = intervalBeforeFrozen;
    }

    @XmlTransient
    public List<CompetitionProblem> getCompetitionProblemList() {
        return competitionProblemList;
    }

    public void setCompetitionProblemList(List<CompetitionProblem> competitionProblemList) {
        this.competitionProblemList = competitionProblemList;
    }

    @XmlTransient
    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition)) {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netcracker.databasemodul.entity.Competition[ id=" + id + " ]";
    }

}