package ramya.io.simple.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
    public class User {

        @Id
        @Column(columnDefinition = "VARCHAR(36)")
        private String id;
        private String firstName;
        private String lastName;

        @Column(unique=true)
        private String email;

        @ManyToMany
        private List<Address> addresses ;


        public User(){
            this.id= UUID.randomUUID().toString();
        }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(Address address) {
        this.addresses = addresses;
    }

    public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + addresses +
                '}';
    }
}

