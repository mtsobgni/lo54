package fr.utbm.lo54.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name="id_client")
    private int idClient;

    @Column(name = "lastname")
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private int phone;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_session")
    private CourseSession idSession;

    public Client() {
    }

    public Client(int idClient, String lastname, String firstname, String address, int phone, String email, CourseSession idSession) {
        this.idClient = idClient;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idSession = idSession;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", idSession=" + idSession +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient &&
                phone == client.phone &&
                Objects.equals(lastname, client.lastname) &&
                Objects.equals(firstname, client.firstname) &&
                Objects.equals(address, client.address) &&
                Objects.equals(email, client.email) &&
                Objects.equals(idSession, client.idSession);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idClient, lastname, firstname, address, phone, email, idSession);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getIdSession() {
        return idSession;
    }

    public void setIdSession(CourseSession idSession) {
        this.idSession = idSession;
    }
}
