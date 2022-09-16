package edu.eci.cvds.tdd.registry;


import java.util.ArrayList;

public class Registry {

    private RegistryValidate r;
    private ArrayList<Person> voters;
    public Registry(RegistryValidate r){
        this.r = r;
        voters = new ArrayList<>();
    }

    public RegisterResult registerVoter(Person p){
        RegisterResult voter = r.validateVoter(voters, p);
        if(voter.equals(RegisterResult.VALID)){
            voters.add(p);
        }
        return voter;
    }

}

