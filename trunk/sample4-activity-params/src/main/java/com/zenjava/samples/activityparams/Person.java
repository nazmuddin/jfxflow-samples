package com.zenjava.samples.activityparams;

public class Person
{
    private long id;
    private String firstName;
    private String lastName;
    private String profile;

    public Person(long id, String firstName, String lastName, String profile)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profile = profile;
    }

    public long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getProfile()
    {
        return profile;
    }

    public String toString()
    {
        return String.format("%s %s", firstName, lastName);
    }
}
