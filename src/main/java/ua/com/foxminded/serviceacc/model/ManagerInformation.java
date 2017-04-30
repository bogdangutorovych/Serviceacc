package ua.com.foxminded.serviceacc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "manager_info")
public class ManagerInformation {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "manager_info_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "info_type_id")
    private ManagerInformationType managerInformationType;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "manager_id")
    private Manager manager; 

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ManagerInformation() {
    }

    public ManagerInformation(String content, ManagerInformationType managerInformationType, boolean active) {

        this.content = content;
        this.managerInformationType = managerInformationType;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ManagerInformationType getManagerInformationType() {
        return managerInformationType;
    }

    public void setManagerInformationType(ManagerInformationType managerInformationType) {
        this.managerInformationType = managerInformationType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ManagerInformation [id=" + id + ", content=" + content + ", managerInformationType="
                + managerInformationType + ", active=" + active + "]";
    }

}