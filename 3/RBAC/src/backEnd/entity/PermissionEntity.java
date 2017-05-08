package backEnd.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wtupc96 on 2017/5/7.
 */
@Entity
@Table(name = "permission", schema = "rbac_system", catalog = "")
public class PermissionEntity {
    private int permissionId;
    private String permissionName;
    private Collection<RolePermissionEntity> rolePermissionsByPermissionId;

    @Id
    @Column(name = "permission_id", nullable = false)
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name", nullable = false, length = 20)
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionEntity that = (PermissionEntity) o;

        if (permissionId != that.permissionId) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId;
        result = 31 * result + (permissionName != null ? permissionName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "permissionByPermissionId")
    public Collection<RolePermissionEntity> getRolePermissionsByPermissionId() {
        return rolePermissionsByPermissionId;
    }

    public void setRolePermissionsByPermissionId(Collection<RolePermissionEntity> rolePermissionsByPermissionId) {
        this.rolePermissionsByPermissionId = rolePermissionsByPermissionId;
    }
}
