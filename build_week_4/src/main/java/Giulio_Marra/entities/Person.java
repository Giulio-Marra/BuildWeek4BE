package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    @OneToOne(mappedBy = "user")
    private Card card;

    @OneToMany(mappedBy = "user")
    private List<Ticket> ticket;

    public Person() {

    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
