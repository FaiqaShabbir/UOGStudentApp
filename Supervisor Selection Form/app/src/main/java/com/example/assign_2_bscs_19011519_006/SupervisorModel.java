package com.example.assign_2_bscs_19011519_006;

public class SupervisorModel extends Application{
    private String Synop1, Summ1, Sign1;
    private String Synop2, Summ2, Sign2;
    private String Synop3, Summ3, Sign3;

    public SupervisorModel(String studentName, String fatherName,
                           String registrationNo, String synop1,
                           String summ1, String sign1, String synop2,
                           String summ2, String sign2, String synop3,
                           String summ3, String sign3) {
        super();
        super.setStudentName(studentName);
        super.setFatherName(fatherName);
        super.setRegistrationNo(registrationNo);
        Synop1 = synop1;
        Summ1 = summ1;
        Sign1 = sign1;
        Synop2 = synop2;
        Summ2 = summ2;
        Sign2 = sign2;
        Synop3 = synop3;
        Summ3 = summ3;
        Sign3 = sign3;
    }

    public String getSynop1() {
        return Synop1;
    }

    public void setSynop1(String synop1) {
        Synop1 = synop1;
    }

    public String getSumm1() {
        return Summ1;
    }

    public void setSumm1(String summ1) {
        Summ1 = summ1;
    }

    public String getSign1() {
        return Sign1;
    }

    public void setSign1(String sign1) {
        Sign1 = sign1;
    }

    public String getSynop2() {
        return Synop2;
    }

    public void setSynop2(String synop2) {
        Synop2 = synop2;
    }

    public String getSumm2() {
        return Summ2;
    }

    public void setSumm2(String summ2) {
        Summ2 = summ2;
    }

    public String getSign2() {
        return Sign2;
    }

    public void setSign2(String sign2) {
        Sign2 = sign2;
    }

    public String getSynop3() {
        return Synop3;
    }

    public void setSynop3(String synop3) {
        Synop3 = synop3;
    }

    public String getSumm3() {
        return Summ3;
    }

    public void setSumm3(String summ3) {
        Summ3 = summ3;
    }

    public String getSign3() {
        return Sign3;
    }

    public void setSign3(String sign3) {
        Sign3 = sign3;
    }
}
