package com.durong.student_info_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "role_info")
public class Role {
    @Id
    @Column(name = "log_id")
    private String logId;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "role_weight")
    private Integer roleWeight;

    public Role() {
    }

    public Role(String logId, String roleId, Integer roleWeight) {
        this.logId = logId;
        this.roleId = roleId;
        this.roleWeight = roleWeight;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleWeight() {
        return roleWeight;
    }

    public void setRoleWeight(Integer roleWeight) {
        this.roleWeight = roleWeight;
    }

    @Override
    public String toString() {
        return "Role{" +
                "logId='" + logId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleWeight='" + roleWeight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getLogId().equals(role.getLogId()) && getRoleId().equals(role.getRoleId()) && getRoleWeight().equals(role.getRoleWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogId(), getRoleId(), getRoleWeight());
    }
}
