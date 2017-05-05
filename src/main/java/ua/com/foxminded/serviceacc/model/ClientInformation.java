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
@Table(name = "client_info")
@SQLDelete(sql = "UPDATE client_info SET active = false WHERE id = ?")
public class ClientInformation {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "client_info_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "info_type_id")
    private ClientInformationType clientInformationType;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientInformation() {
    }

    public ClientInformation(String content, ClientInformationType clientInformationType, boolean active) {

        this.content = content;
        this.clientInformationType = clientInformationType;
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

    public ClientInformationType getClientInformationType() {
        return clientInformationType;
    }

    public void setClientInformationType(ClientInformationType clientInformationType) {
        this.clientInformationType = clientInformationType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ClientInformation that = (ClientInformation) o;

        if (content != null ? !content.equals(that.content) : that.content != null)
            return false;
        return clientInformationType != null ? clientInformationType.equals(that.clientInformationType)
                : that.clientInformationType == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (clientInformationType != null ? clientInformationType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "id=" + id + ", content='" + content + '\'' + ", clientInformationType="
                + clientInformationType + '}';
    }
}