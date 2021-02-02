package service.infrastructure;

import javax.persistence.*;

@Entity(name= "User")
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "user_sequence")
    @SequenceGenerator(name="user_sequence", sequenceName = "user_seq")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    public User (){ }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
