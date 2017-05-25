package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "manager")
@SQLDelete(sql = "UPDATE manager SET is_deleted = true WHERE id = ?")
@Loader(namedQuery = "findManagerById")
@NamedQuery(name = "findManagerById", query = "FROM Manager WHERE id = ?1 AND isDeleted = false")
@Where(clause = "is_deleted = false")
public class Manager {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "manager_id_seq"),
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

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "clients_limit")
    private Integer clientsLimit = 0;

    public Manager() {

    }

    public Manager(String firstName, String lastName, LocalDate birthday, int clientsLimit, boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.clientsLimit = clientsLimit;
        this.isDeleted = isDeleted;
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

    public Integer getClientsLimit() {
        return clientsLimit;
    }

    public void setClientsLimit(Integer clientsLimit) {
        this.clientsLimit = clientsLimit;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
