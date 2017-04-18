package ua.com.foxminded.serviceacc.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "contact_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "contact_name")
    private String contactName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type_id")
    private ContactType contactType;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Contact() {
    }

    public Contact(Client client, Manager manager, String contactName, ContactType contactType, boolean active) {
        this.client = client;
        this.manager = manager;
        this.contactName = contactName;
        this.contactType = contactType;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactName != null ? !contactName.equals(contact.contactName) : contact.contactName != null) return false;
        return contactType != null ? contactType.equals(contact.contactType) : contact.contactType == null;
    }

    @Override
    public int hashCode() {
        int result = contactName != null ? contactName.hashCode() : 0;
        result = 31 * result + (contactType != null ? contactType.hashCode() : 0);
        return result;
    }
}