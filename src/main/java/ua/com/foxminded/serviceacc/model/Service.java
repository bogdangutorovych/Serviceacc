package ua.com.foxminded.serviceacc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "service")
@SQLDelete(sql = "UPDATE service SET is_deleted = true WHERE id = ?")
@Loader(namedQuery = "findServiceById")
@NamedQuery(name = "findServiceById", query = "FROM Service WHERE id = ?1 AND isDeleted = false")
@Where(clause = "is_deleted = false")
public class Service {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "service_id_seq"),
            @Parameter(name = "initial_value", value = "100"), @Parameter(name = "increment_size", value = "50") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Money> prices = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id")
    private Money managerRate = new Money();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Service() {

    }

    public Service(String name, Set<Money> prices) {
        this.name = name;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Money> getPrices() {
        return prices;
    }

    public void setPrices(Set<Money> prices) {
        this.prices = prices;
    }

    public Money getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(Money managerRate) {
        this.managerRate = managerRate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", prices="
                + prices + ", managerRate=" + managerRate + ", isDeleted=" + isDeleted + '}';
    }

}
