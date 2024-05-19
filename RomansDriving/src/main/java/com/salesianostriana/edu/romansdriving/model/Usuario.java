package com.salesianostriana.edu.romansdriving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "compra_carnet",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "carnet_id")
	)
	private List<Carnet> carnet = new ArrayList<>();

	private String nombre, dni, apellidos, username, email, password, telefono;
	private boolean tieneCarnetAutoescuela, isAdmin;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Clase> clases = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";

		if (isAdmin) {
			role += "ADMIN";
		} else {
			role += "USER";
		}

		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
