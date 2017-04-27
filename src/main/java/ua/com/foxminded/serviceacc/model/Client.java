package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "client")

@SQLDelete(sql = "UPDATE client SET active = false WHERE id = ?")
@Loader(namedQuery = "findClientById")
@NamedQuery(name = "findClientById", query = "FROM Client WHERE id = ?1 AND active = true")
@Where(clause = "active = true")

public class Client {
    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "client_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_day")
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_level_type_id", referencedColumnName = "id")
    private ClientLevelType level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_status_type_id", referencedColumnName = "id")
    private ClientStatusType status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id", updatable = false)
    private Set<ClientStatusHistory> clientHistory = new HashSet<>();

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate birthday, ClientLevelType level, ClientStatusType status,
            Set<ClientInformation> informations, Set<ClientStatusHistory> clientHistory, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.level = level;
        this.status = status;
        this.clientHistory = clientHistory;
        this.active = active;
    }

    public Client(String firstName, String lastName, LocalDate birthday, ClientLevelType level, ClientStatusType status,
            Set<ClientStatusHistory> clientHistory, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.level = level;
        this.status = status;
        this.clientHistory = clientHistory;
        this.active = active;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ClientLevelType getLevel() {
        return level;
    }

    public void setLevel(ClientLevelType level) {
        this.level = level;
    }

    public ClientStatusType getStatus() {
        return status;
    }

    public void setStatus(ClientStatusType status) {
        this.status = status;
    }

    public Set<ClientStatusHistory> getClientHistory() {
        return clientHistory;
    }
    
    public void setClientHistory(Set<ClientStatusHistory> clientHistory) {
        this.clientHistory = clientHistory;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
