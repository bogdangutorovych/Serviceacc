package ua.com.foxminded.serviceacc.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@SQLDelete(sql = "UPDATE service SET active = false WHERE id = ?")
@Loader(namedQuery = "findServiceById")
@NamedQuery(name = "findServiceById", query = "FROM Service WHERE id = ?1 AND active = true")
@Where(clause = "active = true")
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

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Service() {

    }

    public Service(String name, String description, Set<Money> prices, Money managerRate) {
        this.name = name;
        this.description = description;
        this.prices = prices;
        this.managerRate = managerRate;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Service{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", prices=" + prices +
            ", managerRate=" + managerRate +
            ", active=" + active +
            '}';
    }
}
