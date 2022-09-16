package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;
public class RegistryValidate {
    public RegisterResult validateVoter(ArrayList<Person> persons, Person p){

            int age = p.getAge();
            boolean state = p.isAlive();
            boolean flag = false;
            RegisterResult result = RegisterResult.VALID;
            for(Person x: persons){
                if(x.getId() == p.getId()){
                    result = RegisterResult.DUPLICATED;
                    flag = true;
                }
            }
            if (!flag) {
                if (age < 0 || age > 110) {
                    result = RegisterResult.INVALID_AGE;
                } else if (age < 18 && age > 0) {
                    result = RegisterResult.UNDERAGE;
                } else if (state != Boolean.TRUE) {
                    result = RegisterResult.DEAD;
                } else {
                    result = RegisterResult.VALID;
                }

            }
            return result;
    }
}
