package backEnd.entity;

import javax.persistence.*;

/**
 * Created by wtupc96 on 2017/5/7.
 */
@Entity
@Table(name = "grade", schema = "rbac_system", catalog = "")
public class GradeEntity {
    private int gradeId;
    private int assignmentId;
    private AssignmentEntity assignmentByAssignmentId;

    @Id
    @Column(name = "grade_id", nullable = false)
    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "assignment_id", nullable = false)
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeEntity that = (GradeEntity) o;

        if (gradeId != that.gradeId) return false;
        if (assignmentId != that.assignmentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gradeId;
        result = 31 * result + assignmentId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id", nullable = false)
    public AssignmentEntity getAssignmentByAssignmentId() {
        return assignmentByAssignmentId;
    }

    public void setAssignmentByAssignmentId(AssignmentEntity assignmentByAssignmentId) {
        this.assignmentByAssignmentId = assignmentByAssignmentId;
    }
}
