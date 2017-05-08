package backEnd.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wtupc96 on 2017/5/7.
 */
@Entity
@Table(name = "assignment", schema = "rbac_system", catalog = "")
public class AssignmentEntity {
    private int assignmentId;
    private int roleId;
    private String content;
    private RoleEntity roleByRoleId;
    private Collection<GradeEntity> gradesByAssignmentId;

    @Id
    @Column(name = "assignment_id", nullable = false)
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 2048)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentEntity that = (AssignmentEntity) o;

        if (assignmentId != that.assignmentId) return false;
        if (roleId != that.roleId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignmentId;
        result = 31 * result + roleId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @OneToMany(mappedBy = "assignmentByAssignmentId")
    public Collection<GradeEntity> getGradesByAssignmentId() {
        return gradesByAssignmentId;
    }

    public void setGradesByAssignmentId(Collection<GradeEntity> gradesByAssignmentId) {
        this.gradesByAssignmentId = gradesByAssignmentId;
    }
}
