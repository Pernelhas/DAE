package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="UTILIZADORES")
public class Utilizador extends GeneralData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    
    @NotNull
    private String primeiroNome;
    
    private String ultimoNome;
    
    private String morada;
    @NotNull
    private String contacto;
    @NotNull
    private String numeroContribuinte;

    public Utilizador() {
    }

    public Utilizador(String username, String password, String email, String primeiroNome, String ultimoNome, String morada, String contacto, String numeroContribuinte) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.morada = morada;
        this.contacto = contacto;
        this.numeroContribuinte = numeroContribuinte;
    }

    public Utilizador(String username, String password, String email, String primeiroNome, String contacto, String numeroContribuinte) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.primeiroNome = primeiroNome;
        this.contacto = contacto;
        this.numeroContribuinte = numeroContribuinte;
        this.ultimoNome = null;
        this.morada = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.primeiroNome);
        hash = 59 * hash + Objects.hashCode(this.ultimoNome);
        hash = 59 * hash + Objects.hashCode(this.morada);
        hash = 59 * hash + Objects.hashCode(this.contacto);
        hash = 59 * hash + Objects.hashCode(this.numeroContribuinte);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", morada=" + morada + ", contacto=" + contacto + ", numeroContribuinte=" + numeroContribuinte + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getMorada() {
        return morada;
    }

    public String getContacto() {
        return contacto;
    }

    public String getNumeroContribuinte() {
        return numeroContribuinte;
    }

    public void setUsername(String username) {
        setChange();
        this.username = username;
    }

    public void setEmail(String email) {
        setChange();
        this.email = email;
    }
    
    public void setPassword(String password) {
        setChange();
        this.password = password;
    }

    public void setPrimeiroNome(String primeiroNome) {
        setChange();
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        setChange();
        this.ultimoNome = ultimoNome;
    }

    public void setMorada(String morada) {
        setChange();
        this.morada = morada;
    }

    public void setContacto(String contacto) {
        setChange();
        this.contacto = contacto;
    }

    public void setNumeroContribuinte(String numeroContribuinte) {
        setChange();
        this.numeroContribuinte = numeroContribuinte;
    }
    
}
