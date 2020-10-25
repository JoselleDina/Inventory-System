package ac.za.cput.entity.user;
/*
 *@author @joselledina
 * Description: Entity for  Login
 * Date: 28 June 2020
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Login implements Serializable {
    @Id
    private String loginId;
    private  String emailAddress;
    private int password;


    protected Login(){}
    private Login(Builder builder){
        this.loginId= builder.loginId;
        this.emailAddress= builder.emailAddress;
        this.password= builder.password;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return loginId.equals(login.loginId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId);
    }

    public static class Builder{
        private String loginId;
        private String emailAddress;
        private int password;

        public Builder setEmailAddress(final String emailAddress)
        {
            this.emailAddress= emailAddress;
            return this;
        }
        public Builder setPassword(final int password)
        {
            this.password= password;
            return this;
        }
        public Builder setLoginId(final String loginId)
        {
            this.loginId= loginId;
            return this;
        }

        public Builder copy(Login login){
            this.emailAddress= login.emailAddress;
            this.password= login.password;
            this.loginId= login.loginId;
            return this;
        }
        public Login build() {
            return new Login(this);
        }

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPassword() {
        return password;
    }

    public String getLoginId() {
        return loginId;
    }


    @Override
    public String toString() {
        return "Login{" +
                "email_address='" + emailAddress + '\'' +
                ", password=" + password +
                ", login_id="+ loginId +
                '}';
    }
}


