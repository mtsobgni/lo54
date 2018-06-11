package fr.utbm.lo54.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity(name="course_session")
public class CourseSession implements Serializable {

    @Id
    @Column(name = "id_session")
    private int idSession;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="max")
    private int max;

    @ManyToOne
    @JoinColumn(name = "id")
    private Location id;

    @ManyToOne
    @JoinColumn(name = "code")
    private Course code;

    public CourseSession() {
    }

    public CourseSession(Date startDate, Date endDate, int max, Location id, Course code) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.id = id;
        this.code = code;
    }

    public CourseSession(int idSession, Date startDate, Date endDate, int max, Location id, Course code) {
        this.idSession = idSession;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.id = id;
        this.code = code;
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "idSession=" + idSession +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", max=" + max +
                ", id=" + id +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSession that = (CourseSession) o;
        return idSession == that.idSession &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(max, that.max) &&
                Objects.equals(id, that.id) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSession, startDate, endDate, max, id, code);
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setId(Location id) {
        this.id = id;
    }

    public void setCode(Course code) {
        this.code = code;
    }

    public int getIdSession() {
        return idSession;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getMax() {
        return max;
    }

    public Location getId() {
        return id;
    }

    public Course getCode() {
        return code;
    }
}
