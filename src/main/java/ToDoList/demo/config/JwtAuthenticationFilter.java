package ToDoList.demo.config;

import ToDoList.demo.Employee.EmployeeService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // by extending this class, it means that the authentication will trigger for every request made

    private final JwtService jwtService;    //creating new class in order to manipulate(i.e. extract email) the jwt

    private EmployeeService employeeService;

    @Override
    protected void doFilterInternal(
                                    @NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization"); // we need to JWT auth token within the header
        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // if the conditions aren't met, the request and response will be passed to the next filter
            filterChain.doFilter(request, response);
            return; // stops the execution
        }
        // gets token from header, starts at index 7 bc the previous indexes were for "Bearer"
        jwt = authHeader.substring(7);

        // extracting user email from JWT token
        userEmail = jwtService.extractUsername(jwt);

        // checking if username isn't empty and if user isn't connected yet
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // check if we have the user within the database
            UserDetails userDetails = this.employeeService
        }
    }
}
