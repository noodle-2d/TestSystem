package com.netcracker.databasemodul.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "problem", catalog = "test_system", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problem.findAll", query = "SELECT p FROM Problem p"),
    @NamedQuery(name = "Problem.findById", query = "SELECT p FROM Problem p WHERE p.id = :id"),
    @NamedQuery(name = "Problem.findByType", query = "SELECT p FROM Problem p WHERE p.type = :type"),
    @NamedQuery(name = "Problem.findByName", query = "SELECT p FROM Problem p WHERE p.name = :name"),
    @NamedQuery(name = "Problem.findByCheckerType", query = "SELECT p FROM Problem p WHERE p.checkerType = :checkerType"),
    @NamedQuery(name = "Problem.findByTimeLimit", query = "SELECT p FROM Problem p WHERE p.timeLimit = :timeLimit"),
    @NamedQuery(name = "Problem.findByMemoryLimit", query = "SELECT p FROM Problem p WHERE p.memoryLimit = :memoryLimit"),
    @NamedQuery(name = "Problem.findByDescriptionFileExists", query = "SELECT p FROM Problem p WHERE p.descriptionFileExists = :descriptionFileExists"),
    @NamedQuery(name = "Problem.findByValidated", query = "SELECT p FROM Problem p WHERE p.validated = :validated"),
    @NamedQuery(name = "Problem.findByFolderName", query = "SELECT p FROM Problem p WHERE p.folderName = :folderName")})
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "checker_type")
    private String checkerType;
    @Basic(optional = false)
    @Column(name = "time_limit")
    private int timeLimit;
    @Basic(optional = false)
    @Column(name = "memory_limit")
    private short memoryLimit;
    @Basic(optional = false)
    @Column(name = "description_file_exists")
    private boolean descriptionFileExists;
    @Basic(optional = false)
    @Column(name = "validated")
    private boolean validated;
    @Basic(optional = false)
    @Column(name = "folder_name")
    private String folderName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problemId")
    private List<CompetitionProblem> competitionProblemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problemId")
    private List<AuthorDecision> authorDecisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problemId")
    private List<TestGroup> testGroupList;

    public Problem() {
    }

    public Problem(Integer id) {
        this.id = id;
    }

    public Problem(Integer id, String type, String name, String checkerType, int timeLimit, short memoryLimit, boolean descriptionFileExists, boolean validated, String folderName) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.checkerType = checkerType;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.descriptionFileExists = descriptionFileExists;
        this.validated = validated;
        this.folderName = folderName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckerType() {
        return checkerType;
    }

    public void setCheckerType(String checkerType) {
        this.checkerType = checkerType;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public short getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(short memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean getDescriptionFileExists() {
        return descriptionFileExists;
    }

    public void setDescriptionFileExists(boolean descriptionFileExists) {
        this.descriptionFileExists = descriptionFileExists;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @XmlTransient
    public List<CompetitionProblem> getCompetitionProblemList() {
        return competitionProblemList;
    }

    public void setCompetitionProblemList(List<CompetitionProblem> competitionProblemList) {
        this.competitionProblemList = competitionProblemList;
    }

    @XmlTransient
    public List<AuthorDecision> getAuthorDecisionList() {
        return authorDecisionList;
    }

    public void setAuthorDecisionList(List<AuthorDecision> authorDecisionList) {
        this.authorDecisionList = authorDecisionList;
    }

    @XmlTransient
    public List<TestGroup> getTestGroupList() {
        return testGroupList;
    }

    public void setTestGroupList(List<TestGroup> testGroupList) {
        this.testGroupList = testGroupList;
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
        if (!(object instanceof Problem)) {
            return false;
        }
        Problem other = (Problem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netcracker.databasemodul.entity.Problem[ id=" + id + " ]";
    }

}