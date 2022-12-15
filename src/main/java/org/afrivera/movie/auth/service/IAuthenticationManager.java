package org.afrivera.movie.auth.service;

import org.afrivera.movie.auth.dto.LoginDto;

public interface IAuthenticationManager {
    void authenticated(LoginDto loginDto);
}
