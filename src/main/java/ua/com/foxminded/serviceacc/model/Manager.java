package ua.com.foxminded.serviceacc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "manager_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_day")
    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Set<ManagerInformation> informations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
    private Set<Client> clients = new HashSet<>();

    @Column(name = "active", nullable = false)
    private boolean active = true;


    public Manager() {

    }

    public Manager(String firstName, String lastName, Date birthday, Set<ManagerInformation> informations, Set<Client> clients,
                   boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.informations = informations;
        this.clients = clients;
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


    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public Set<ManagerInformation> getInformations() {
        return informations;
    }


    public void setInformations(Set<ManagerInformation> informations) {
        this.informations = informations;
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