package com.salesianostriana.edu.romansdriving.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {	
    
	@Id
	@GeneratedValue
    private Long id;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<CompraCarnet>carnet = new ArrayList<>();
	
    private String nombre, dni, apellidos, username, email, password, telefono;
    private boolean tieneCarnetAutoescuela , isAdmin;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
	
   

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_";

        if (isAdmin) {
            role += "ADMIN";
        }
        if (!isAdmin) {
            role += "USER";
        }

        return List.of(new SimpleGrantedAuthority(role));
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
    
	

	
    
	
    
    
    
    
}