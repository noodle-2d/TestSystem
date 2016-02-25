/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ataman
 */
@Entity
@Table(name = "submission", catalog = "test_system", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findById", query = "SELECT s FROM Submission s WHERE s.id = :id"),
    @NamedQuery(name = "Submission.findBySubmissionTime", query = "SELECT s FROM Submission s WHERE s.submissionTime = :submissionTime"),
    @NamedQuery(name = "Submission.findByFolderName", query = "SELECT s FROM Submission s WHERE s.folderName = :folderName"),
    @NamedQuery(name = "Submission.findByVerdict", query = "SELECT s FROM Submission s WHERE s.verdict = :verdict"),
    @NamedQuery(name = "Submission.findByWrongTestNumber", query = "SELECT s FROM Submission s WHERE s.wrongTestNumber = :wrongTestNumber"),
    @NamedQuery(name = "Submission.findByDecisionTime", query = "SELECT s FROM Submission s WHERE s.decisionTime = :decisionTime"),
    @NamedQuery(name = "Submission.findByDecisionMemory", query = "SELECT s FROM Submission s WHERE s.decisionMemory = :decisionMemory"),
    @NamedQuery(name = "Submission.findByPoints", query = "SELECT s FROM Submission s WHERE s.points = :points")})
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submission_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "folder_name")
    private String folderName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "verdict")
    private String verdict;
    @Column(name = "wrong_test_number")
    private Short wrongTestNumber;
    @Column(name = "decision_time")
    private Integer decisionTime;
    @Column(name = "decision_memory")
    private Integer decisionMemory;
    @Column(name = "points")
    private Short points;
    @JoinColumn(name = "competition_problem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompetitionProblem competitionProblemId;
    @JoinColumn(name = "compilator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compilator compilatorId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Submission() {
    }

    public Submission(Integer id) {
        this.id = id;
    }

    public Submission(Integer id, Date submissionTime, String folderName, String verdict) {
        this.id = id;
        this.submissionTime = submissionTime;
        this.folderName = folderName;
        this.verdict = verdict;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public Short getWrongTestNumber() {
        return wrongTestNumber;
    }

    public void setWrongTestNumber(Short wrongTestNumber) {
        this.wrongTestNumber = wrongTestNumber;
    }

    public Integer getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(Integer decisionTime) {
        this.decisionTime = decisionTime;
    }

    public Integer getDecisionMemory() {
        return decisionMemory;
    }

    public void setDecisionMemory(Integer decisionMemory) {
        this.decisionMemory = decisionMemory;
    }

    public Short getPoints() {
        return points;
    }

    public void setPoints(Short points) {
        this.points = points;
    }

    public CompetitionProblem getCompetitionProblemId() {
        return competitionProblemId;
    }

    public void setCompetitionProblemId(CompetitionProblem competitionProblemId) {
        this.competitionProblemId = competitionProblemId;
    }

    public Compilator getCompilatorId() {
        return compilatorId;
    }

    public void setCompilatorId(Compilator compilatorId) {
        this.compilatorId = compilatorId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netcracker.entity.Submission[ id=" + id + " ]";
    }
    
}