package com.individual.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

   private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserCreation> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/search/{partial}", method = RequestMethod.GET)
    public List<UserCreation> getByFullName(@PathVariable String partial){
      return userRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(partial, partial);


    }

    @RequestMapping(value = "/search/firstname/{partial}", method = RequestMethod.GET)
    public List<UserCreation> getByFirstName(@PathVariable String partial){
        return userRepository.findByFirstNameContainingIgnoreCase(partial);
    }

    @RequestMapping(value = "/search/lastname/{partial}", method = RequestMethod.GET)
    public List<UserCreation> getByLastName(@PathVariable String partial){
        return userRepository.findByLastNameContainingIgnoreCase(partial);

    }

    @RequestMapping(value = "/search/accountnumber/{exact}", method = RequestMethod.GET)
    public List<UserCreation> getByAccountNumber(@PathVariable long exact){
        return userRepository.findByAccountNumber(exact);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<UserCreation> create(@RequestBody UserCreation userCreation){
        userRepository.save(userCreation);

        return userRepository.findAll();
    }

    @RequestMapping(value = "/update/{exact}", method = RequestMethod.PUT)
    public List<UserCreation> update(@RequestBody UserCreation userCreation, @PathVariable long exact){
        UserCreation userCreation1 = userRepository.findByAccountNumberEquals(exact);
        userCreation1.setFirstName(userCreation.getFirstName());
        userCreation1.setLastName(userCreation.getLastName());
        userRepository.save(userCreation);

        return userRepository.findAll();
    }

    @RequestMapping(value = "/delete/{accountNumber}", method = RequestMethod.POST)
    public List<UserCreation> remove(@PathVariable long accountNumber){
        userRepository.deleteById(accountNumber);
        return  userRepository.findAll();
    }
}
