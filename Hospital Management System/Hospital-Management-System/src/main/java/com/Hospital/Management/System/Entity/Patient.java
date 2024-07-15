package com.Hospital.Management.System.Entity;


import jakarta.persistence.*;

@Entity
@Table(name ="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String age;
    private String blood;
    private String priscription;
    private String dose;
    private String fees;
    private String urgency;

    public Patient(long id, String name, String age, String blood, String priscription, String dose, String fees, String urgency) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.blood = blood;
        this.priscription = priscription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPriscription() {
        return priscription;
    }

    public void setPriscription(String priscription) {
        this.priscription = priscription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Patient(){
        super();
    }
}
