package com.co.enggit.modules.login.rest;

import com.co.enggit.modules.login.model.Roles;
import com.co.enggit.modules.login.model.Users;
import com.co.enggit.modules.login.model.dto.LoginDTO;
import com.co.enggit.modules.login.model.dto.SignupDTO;
import com.co.enggit.modules.login.model.ro.UsersRO;
import com.co.enggit.modules.login.repository.RoleRepository;
import com.co.enggit.modules.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

/**
 * @author ef-jasper
 */

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/list")
    public ResponseEntity<Optional<Users>> list(@RequestBody UsersRO usersRO){
        Optional<Users> listOfUsers = userRepository.findAllByUsernameContainsIgnoreCaseOrEmailContainingIgnoreCase(usersRO.getUsername(), usersRO.getEmail());
        return new ResponseEntity<>(listOfUsers,HttpStatus.OK);

    }

    //home page
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(), loginDTO.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User signed-in successfully", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupDTO signupDTO){

        //check username in DB if existing
        if(userRepository.existsByUsername(signupDTO.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        //check email in DB if existing
        if(userRepository.existsByEmail(signupDTO.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Users user = new Users();
        user.setFirstName(signupDTO.getFirstName());
        user.setLastName(signupDTO.getLastName());
        user.setMobile(signupDTO.getMobile());
        user.setUsername(signupDTO.getUsername());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));

        Roles roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoleId(roles.getId());
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("Registered sucessfully", HttpStatus.OK);
    }


}
