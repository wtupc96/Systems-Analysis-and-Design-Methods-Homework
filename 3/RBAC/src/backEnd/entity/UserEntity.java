package backEnd.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wtupc96 on 2017/5/7.
 */
@Entity
@Table(name = "user", schema = "rbac_system", catalog = "")
public class UserEntity {
    private int userid;
    private String username;
    private String password;
    private Collection<UserRoleEntity> userRolesByUserid;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<UserRoleEntity> getUserRolesByUserid() {
        return userRolesByUserid;
    }

    public void setUserRolesByUserid(Collection<UserRoleEntity> userRolesByUserid) {
        this.userRolesByUserid = userRolesByUserid;
    }
}
