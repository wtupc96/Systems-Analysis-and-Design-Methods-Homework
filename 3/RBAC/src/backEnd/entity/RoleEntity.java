package backEnd.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wtupc96 on 2017/5/7.
 */
@Entity
@Table(name = "role", schema = "rbac_system", catalog = "")
public class RoleEntity {
    private int roleId;
    private String roleName;
    private Collection<AssignmentEntity> assignmentsByRoleId;
    private Collection<RolePermissionEntity> rolePermissionsByRoleId;
    private Collection<UserRoleEntity> userRolesByRoleId;

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 20)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (roleId != that.roleId) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<AssignmentEntity> getAssignmentsByRoleId() {
        return assignmentsByRoleId;
    }

    public void setAssignmentsByRoleId(Collection<AssignmentEntity> assignmentsByRoleId) {
        this.assignmentsByRoleId = assignmentsByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RolePermissionEntity> getRolePermissionsByRoleId() {
        return rolePermissionsByRoleId;
    }

    public void setRolePermissionsByRoleId(Collection<RolePermissionEntity> rolePermissionsByRoleId) {
        this.rolePermissionsByRoleId = rolePermissionsByRoleId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserRoleEntity> getUserRolesByRoleId() {
        return userRolesByRoleId;
    }

    public void setUserRolesByRoleId(Collection<UserRoleEntity> userRolesByRoleId) {
        this.userRolesByRoleId = userRolesByRoleId;
    }
}
