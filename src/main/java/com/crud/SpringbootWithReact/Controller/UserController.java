package com.crud.SpringbootWithReact.Controller;

import com.crud.SpringbootWithReact.Exception.UserNotFoundException;
import com.crud.SpringbootWithReact.Model.User;
import com.crud.SpringbootWithReact.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://react-project-by-sm.vercel.app/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User>  getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return  userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
         return  userRepository.findById(id).map(user->{
             user.setUsername(newUser.getUsername());
             user.setEmail(newUser.getEmail());
             user.setName(newUser.getName());
             return  userRepository.save(user);
         }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
       if(!userRepository.existsById(id))  {
           throw new UserNotFoundException(id);
       }
       userRepository.deleteById(id);
       return  "User with id "+id+" has been deleted success";
    }
}
