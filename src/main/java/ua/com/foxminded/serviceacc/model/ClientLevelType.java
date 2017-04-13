package ua.com.foxminded.serviceacc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andreb on 04.04.17.
 * Class represent client graduate title
 */
@Entity
@Table(name = "client_level_type")
public class ClientLevelType {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "client_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column (name = "id", unique = true, nullable = false)
    private Long id;
    @Column (name = "code", unique = true, nullable = false)
    private String code;
    @Column (name = "title", nullable = false)
    private String title;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level", orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();
    @Column(name = "active", nullable = false)
    private boolean active = true;

    public ClientLevelType(){
    }
    public ClientLevelType(String code, String title){
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
