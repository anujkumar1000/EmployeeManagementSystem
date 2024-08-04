/*
 * This file is generated by jOOQ.
 */
package com.leadsquared.employeemanagement.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String createdby;
    private LocalDateTime createdOn;
    private String modifiedby;
    private LocalDateTime modifiedOn;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Long employeeId;
    private Long departmentId;
    private Long projectId;
    private Long phoneId;

    public Employee() {}

    public Employee(Employee value) {
        this.createdby = value.createdby;
        this.createdOn = value.createdOn;
        this.modifiedby = value.modifiedby;
        this.modifiedOn = value.modifiedOn;
        this.firstName = value.firstName;
        this.middleName = value.middleName;
        this.lastName = value.lastName;
        this.email = value.email;
        this.employeeId = value.employeeId;
        this.departmentId = value.departmentId;
        this.projectId = value.projectId;
        this.phoneId = value.phoneId;
    }

    public Employee(
        String createdby,
        LocalDateTime createdOn,
        String modifiedby,
        LocalDateTime modifiedOn,
        String firstName,
        String middleName,
        String lastName,
        String email,
        Long employeeId,
        Long departmentId,
        Long projectId,
        Long phoneId
    ) {
        this.createdby = createdby;
        this.createdOn = createdOn;
        this.modifiedby = modifiedby;
        this.modifiedOn = modifiedOn;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.projectId = projectId;
        this.phoneId = phoneId;
    }

    /**
     * Getter for <code>employee.createdBy</code>.
     */
    public String getCreatedby() {
        return this.createdby;
    }

    /**
     * Setter for <code>employee.createdBy</code>.
     */
    public Employee setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    /**
     * Getter for <code>employee.created_on</code>.
     */
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    /**
     * Setter for <code>employee.created_on</code>.
     */
    public Employee setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    /**
     * Getter for <code>employee.modifiedBy</code>.
     */
    public String getModifiedby() {
        return this.modifiedby;
    }

    /**
     * Setter for <code>employee.modifiedBy</code>.
     */
    public Employee setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
        return this;
    }

    /**
     * Getter for <code>employee.modified_on</code>.
     */
    public LocalDateTime getModifiedOn() {
        return this.modifiedOn;
    }

    /**
     * Setter for <code>employee.modified_on</code>.
     */
    public Employee setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    /**
     * Getter for <code>employee.first_name</code>.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for <code>employee.first_name</code>.
     */
    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Getter for <code>employee.middle_name</code>.
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
     * Setter for <code>employee.middle_name</code>.
     */
    public Employee setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * Getter for <code>employee.last_name</code>.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for <code>employee.last_name</code>.
     */
    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Getter for <code>employee.email</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for <code>employee.email</code>.
     */
    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Getter for <code>employee.employee_id</code>.
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Setter for <code>employee.employee_id</code>.
     */
    public Employee setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    /**
     * Getter for <code>employee.department_id</code>.
     */
    public Long getDepartmentId() {
        return this.departmentId;
    }

    /**
     * Setter for <code>employee.department_id</code>.
     */
    public Employee setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * Getter for <code>employee.project_id</code>.
     */
    public Long getProjectId() {
        return this.projectId;
    }

    /**
     * Setter for <code>employee.project_id</code>.
     */
    public Employee setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * Getter for <code>employee.phone_id</code>.
     */
    public Long getPhoneId() {
        return this.phoneId;
    }

    /**
     * Setter for <code>employee.phone_id</code>.
     */
    public Employee setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if (this.createdby == null) {
            if (other.createdby != null)
                return false;
        }
        else if (!this.createdby.equals(other.createdby))
            return false;
        if (this.createdOn == null) {
            if (other.createdOn != null)
                return false;
        }
        else if (!this.createdOn.equals(other.createdOn))
            return false;
        if (this.modifiedby == null) {
            if (other.modifiedby != null)
                return false;
        }
        else if (!this.modifiedby.equals(other.modifiedby))
            return false;
        if (this.modifiedOn == null) {
            if (other.modifiedOn != null)
                return false;
        }
        else if (!this.modifiedOn.equals(other.modifiedOn))
            return false;
        if (this.firstName == null) {
            if (other.firstName != null)
                return false;
        }
        else if (!this.firstName.equals(other.firstName))
            return false;
        if (this.middleName == null) {
            if (other.middleName != null)
                return false;
        }
        else if (!this.middleName.equals(other.middleName))
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!this.lastName.equals(other.lastName))
            return false;
        if (this.email == null) {
            if (other.email != null)
                return false;
        }
        else if (!this.email.equals(other.email))
            return false;
        if (this.employeeId == null) {
            if (other.employeeId != null)
                return false;
        }
        else if (!this.employeeId.equals(other.employeeId))
            return false;
        if (this.departmentId == null) {
            if (other.departmentId != null)
                return false;
        }
        else if (!this.departmentId.equals(other.departmentId))
            return false;
        if (this.projectId == null) {
            if (other.projectId != null)
                return false;
        }
        else if (!this.projectId.equals(other.projectId))
            return false;
        if (this.phoneId == null) {
            if (other.phoneId != null)
                return false;
        }
        else if (!this.phoneId.equals(other.phoneId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.createdby == null) ? 0 : this.createdby.hashCode());
        result = prime * result + ((this.createdOn == null) ? 0 : this.createdOn.hashCode());
        result = prime * result + ((this.modifiedby == null) ? 0 : this.modifiedby.hashCode());
        result = prime * result + ((this.modifiedOn == null) ? 0 : this.modifiedOn.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.middleName == null) ? 0 : this.middleName.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.employeeId == null) ? 0 : this.employeeId.hashCode());
        result = prime * result + ((this.departmentId == null) ? 0 : this.departmentId.hashCode());
        result = prime * result + ((this.projectId == null) ? 0 : this.projectId.hashCode());
        result = prime * result + ((this.phoneId == null) ? 0 : this.phoneId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Employee (");

        sb.append(createdby);
        sb.append(", ").append(createdOn);
        sb.append(", ").append(modifiedby);
        sb.append(", ").append(modifiedOn);
        sb.append(", ").append(firstName);
        sb.append(", ").append(middleName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(email);
        sb.append(", ").append(employeeId);
        sb.append(", ").append(departmentId);
        sb.append(", ").append(projectId);
        sb.append(", ").append(phoneId);

        sb.append(")");
        return sb.toString();
    }
}
