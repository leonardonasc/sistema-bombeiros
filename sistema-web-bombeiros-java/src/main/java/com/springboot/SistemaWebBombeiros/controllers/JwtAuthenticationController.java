package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.JwtRequest;
import com.springboot.sistemawebbombeiros.models.JwtResponse;
import com.springboot.sistemawebbombeiros.models.Usuario;
import com.springboot.sistemawebbombeiros.models.UsuarioResponse;
import com.springboot.sistemawebbombeiros.security.JwtTokenUtil;
import com.springboot.sistemawebbombeiros.service.JwtUserDetailsService;
import com.springboot.sistemawebbombeiros.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Usuario usuario = usuarioRepository.findByMatricula(authenticationRequest.getUsername());
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getMatricula(), usuario.getNomeDeGuerra(), usuario.getEmail(), usuario.getPerfilAcesso());
        return ResponseEntity.ok(new JwtResponse(token, usuarioResponse));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
