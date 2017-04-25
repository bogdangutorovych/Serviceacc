package ua.com.foxminded.serviceacc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by andreb on 04.04.17.
 * Represent contact type
 */
@Entity
@Table(name = "manager_info_type")
public class ManagerInformationType {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "manager_info_type_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column (name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public ManagerInformationType() {
    }
    public ManagerInformationType(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
