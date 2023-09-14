package participant;

import constants.AwardType;
import constants.SportType;

import java.util.List;

/*
    name and surname,
    age, type of sport, list of awards
*/
public class Participant {
    private String name;
    private String surname;
    private int age;
    private SportType sportType;
    private List<Award> awards;

    public Participant(String name, String surname, int age, SportType sportType, List<Award> awards) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setSportType(sportType);
        setAwards(awards);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty or null");

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty() || surname.isBlank())
            throw new IllegalArgumentException("Surname cannot be empty or null");

        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0)
            throw new IllegalArgumentException("Age cannot be negative or zero");

        this.age = age;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        if (sportType == null)
            throw new IllegalArgumentException("Sport type cannot be null");
        this.sportType = sportType;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        if (awards == null)
            throw new IllegalArgumentException("Awards cannot be null");

        this.awards = awards;
    }

    public void addAward(Award award) {
        if (award == null)
            throw new IllegalArgumentException("Award cannot be null");

        this.awards.add(award);
    }

    public void removeAward(Award award) {
        if (award == null)
            throw new IllegalArgumentException("Award cannot be null");

        this.awards.remove(award);
    }

    @Override
    public String toString() {
        return "Name: " + name + "  " +
                "Surname: " + surname + "   " +
                "Age: " + age + "   " +
                "Sport type: " + sportType + "  " +
                "Awards Count: " + awards.size() + "    " +
                "national awards: " + awards.stream().filter(a -> a.getAwardType() == AwardType.NATIONAL).count() + "   " +
                "international awards: " + awards.stream().filter(a -> a.getAwardType() == AwardType.INTERNATIONAL).count();
    }
}
