package edu.eci.cvds.tdd.registry;

import org.junit.*;

public class RegistryTest {
    private Registry registry;
    @Test
    public void validateRegistryResultWhenAPersonHasValidAgeToVote() {
        registry = new Registry(new RegistryValidate());
        Person person = new Person("Brayan", 122, 22, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateRegistryResultWhenAPersonIsDead() {
        registry = new Registry(new RegistryValidate());
        Person person = new Person("David", 1000, 22, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateRegistryResultWhenAPersonHasInvalidAgeToVote() {
        registry = new Registry(new RegistryValidate());
        Person person = new Person("Yeison", 1001, -5, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateRegistryResultWhenAPersonHasUnderageToVote() {
        registry = new Registry(new RegistryValidate());
        Person person = new Person("Camilo", 1002, 10, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateRegistryResultWhenAPersonisDuplicated() {
        registry = new Registry(new RegistryValidate());
        Person person = new Person("Brayan", 122, 22, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Person person_2 = new Person("Sebastian", 122, 25, Gender.MALE, true);
        RegisterResult result_2 = registry.registerVoter(person_2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result_2);
    }
    }










