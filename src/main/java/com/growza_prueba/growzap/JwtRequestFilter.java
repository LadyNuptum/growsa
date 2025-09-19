package com.growza_prueba.growzap;

import com.growza_prueba.growzap.service.UsuariosService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// @Component: Buena práctica para que Spring gestione esta clase como un Bean.
// OncePerRequestFilter: Asegura que el filtro se ejecute una sola vez por cada solicitud.
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UsuariosService userService; // Inyecta el servicio de usuarios para cargar los detalles del usuario.

    @Autowired
    private JwtUtil jwtUtil; // Inyecta la utilidad para manejar la creación y validación de tokens.

    // El método principal del filtro que se ejecuta en cada solicitud HTTP.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Extrae el encabezado "Authorization" de la solicitud.
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // Comprueba si el encabezado existe y si tiene el formato correcto ("Bearer ").
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extrae el token, eliminando el prefijo "Bearer ".
            jwt = authorizationHeader.substring(7);
            // Utiliza JwtUtil para extraer el nombre de usuario del token.
            username = jwtUtil.extractCorreo(jwt);
        }

        // Si se extrajo un nombre de usuario y el contexto de seguridad actual no tiene autenticación...
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Carga los detalles del usuario desde el servicio.
            UserDetails userDetails = userService.loadUserByUsername(username);

            // Crea un token de autenticación para Spring Security.
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            // Establece el token de autenticación en el contexto de seguridad.
            // Esto le dice a Spring que el usuario está autenticado para esta solicitud.
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        // Permite que la solicitud continúe su camino a otros filtros o al controlador.
        chain.doFilter(request, response);
    }
}