package overlapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

public class Member implements Military, Scientist, Specialist {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String placeOfBirth;
    private String[] additionSkills;

    private EnumSet<MemberType> types;

    private String rank, discipline, title, description;

    public Member(String firstName, String lastName, LocalDate birthDate, String placeOfBirth, String[] additionSkills, EnumSet<MemberType> types,
                  String rank, String discipline, String title, String description) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setPlaceOfBirth(placeOfBirth);
        setAdditionSkills(additionSkills);
        setTypes(types);
        if(isMilitary()){
            setMilitaryRank(rank);
        }
        if(isScientist()){
            setScientificDiscipline(discipline);
            setScientificTitle(title);
        }
        if(isSpecialist()){
            setDescription(description);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(firstName.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("Last Name cannot be null");
        }
        if(lastName.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if(birthDate == null){
            throw new IllegalArgumentException("Birth Date cannot be null");
        }
        this.birthDate = birthDate;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        if(placeOfBirth == null){
            throw new IllegalArgumentException("placeOfBirth cannot be null");
        }
        if(placeOfBirth.equals("")){
            throw new IllegalArgumentException("placeOfBirth cannot be empty");
        }
        this.placeOfBirth = placeOfBirth;
    }

    public String[] getAdditionSkills() {
        return additionSkills;
    }

    public void setAdditionSkills(String[] additionSkills) {
        this.additionSkills = additionSkills;
    }

    public EnumSet<MemberType> getTypes() {
//        return Sets.immutableEnumSet(types);
        return null;
    }

    private void setTypes(EnumSet<MemberType> types) {
        if(types == null){
            throw new IllegalArgumentException("types cannot be null");
        }
        if(this.types.size() == 0 && types.size() == 0){
            throw new IllegalArgumentException("should be at lease one type");
        }
        this.types = types;
    }

    @Override
    public String getMilitaryRank() {
        if(!isMilitary()){
            throw new IllegalArgumentException("None military member cannot use this method");
        }
        return rank;
    }

    @Override
    public void setMilitaryRank(String rank) {
        if(!isMilitary()){
            throw new IllegalArgumentException("None military member cannot use this method");
        }
        if(rank == null){
            throw new IllegalArgumentException("Rank cannot be null");
        }
        if(rank.equals("")){
            throw new IllegalArgumentException("Rank cannot be empty");
        }
        this.rank = rank;
    }

    @Override
    public void establishDefensiveInfrastructure() {
        if(!isMilitary()){
            throw new IllegalArgumentException("None military member cannot use this method");
        }
        System.out.println("Establishing Defensive Infrastructure");
    }

    @Override
    public String getScientificDiscipline() {
        if(!isScientist()){
            throw new IllegalArgumentException("None scientist member cannot use this method");
        }
        return discipline;
    }

    @Override
    public String getScientificTitle() {
        if(!isScientist()){
            throw new IllegalArgumentException("None scientist member cannot use this method");
        }
        return title;
    }

    @Override
    public void setScientificDiscipline(String discipline) {
        if(!isScientist()){
            throw new IllegalArgumentException("None scientist member cannot use this method");
        }
        if(discipline == null){
            throw new IllegalArgumentException("discipline cannot be null");
        }
        if(discipline.equals("")){
            throw new IllegalArgumentException("discipline cannot be empty");
        }
        this.discipline = discipline;
    }

    @Override
    public void setScientificTitle(String title) {
        if(!isScientist()){
            throw new IllegalArgumentException("None scientist member cannot use this method");
        }
        if(title == null){
            throw new IllegalArgumentException("title cannot be null");
        }
        if(title.equals("")){
            throw new IllegalArgumentException("title cannot be empty");
        }
        this.title = title;
    }

    @Override
    public String getDescription() {
        if(!isSpecialist()){
            throw new IllegalArgumentException("None specialist member cannot use this method");
        }
        return description;
    }

    @Override
    public void setDescription(String description) {
        if(description == null){
            throw new IllegalArgumentException("description cannot be null");
        }
        if(description.equals("")){
            throw new IllegalArgumentException("description cannot be empty");
        }
        this.description = description;
    }

    @Override
    public String setUpMonitoringSystem() {
        if(!isSpecialist()){
            throw new IllegalArgumentException("None specialist member cannot use this method");
        }
        return "Setting up monitoring system";
    }

    private boolean isMilitary(){
        return types.contains(MemberType.Military);
    }

    private boolean isScientist(){
        return types.contains(MemberType.Scientist);
    }

    private boolean isSpecialist(){
        return types.contains(MemberType.Specialist);
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", additionSkills=" + Arrays.toString(additionSkills) +
                ", types=" + types +
                '}';
    }
}
