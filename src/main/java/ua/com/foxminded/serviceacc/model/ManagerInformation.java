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
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "manager_info")
@SQLDelete(sql = "UPDATE manager_info SET is_deleted = true WHERE id = ?")
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

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerInformation that = (ManagerInformation) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return managerInformationType != null ? managerInformationType.equals(that.managerInformationType) : that.managerInformationType == null;

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (managerInformationType != null ? managerInformationType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ManagerInformation [id=" + id + ", content=" + content + ", managerInformationType="
                + managerInformationType + ", isDeleted=" + isDeleted + "]";
    }

}
