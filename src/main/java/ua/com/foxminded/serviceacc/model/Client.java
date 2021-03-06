package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@SQLDelete(sql = "UPDATE client SET is_deleted = true WHERE id = ?")
@Loader(namedQuery = "findClientById")
@NamedQuery(name = "findClientById", query = "FROM Client WHERE id = ?1 AND isDeleted = false")
@Where(clause = "is_deleted = false")

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

    @OneToMany(
        mappedBy = "client",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @Where(clause = "is_deleted = false")
    private List<ClientInformation> information = new ArrayList<>();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ClientInformation> getInformation() {
        return information;
    }

    public void setInformation(List<ClientInformation> information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void addClientInformation(ClientInformation info){
        information.add(info);
        info.setClient(this);
    }

    public void removeClientInformation(ClientInformation info){
        information.remove(info);
        info.setClient(null);
    }
}
