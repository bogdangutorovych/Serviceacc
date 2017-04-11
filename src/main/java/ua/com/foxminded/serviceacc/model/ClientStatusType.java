package ua.com.foxminded.serviceacc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andreb on 04.04.17.
 * Represent Client title
 */
@Entity
@Table(name = "client_status_type")
public class ClientStatusType {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "client_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();

    @Column(name = "active", nullable = false)
    private boolean active = true;


    public ClientStatusType() {
    }

    public ClientStatusType(String code, String title) {
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}