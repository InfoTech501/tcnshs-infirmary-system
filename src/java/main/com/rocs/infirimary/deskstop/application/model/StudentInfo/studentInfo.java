package main.com.rocs.infirimary.deskstop.application.model.StudentInfo;

public class studentInfo {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int age;
    private String strand;
    private long LRN;
    private String birthDate;
    private String gender;
    private String email;
    private String contactNumber;
    private String guardianContactNumber;

    public studentInfo(int id, String firstName, String middleName, String lastName, String address, int age, String strand, long LRN, String birthDate, String gender, String email, String contactNumber, String guardianContactNumber) {
        this.id = id;
        this.LRN = LRN;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.strand = strand;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.contactNumber = contactNumber;
        this.guardianContactNumber = guardianContactNumber;
    }

    public studentInfo() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLRN(long LRN) {
        this.LRN = LRN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public int getId() {
        return this.id;
    }

    public long getLRN() {
        return this.LRN;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    public String getStrand() {
        return this.strand;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getGender() {
        return this.gender;
    }

    public String getGmail() {
        return this.email;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public String getGuardianContactNumber() {
        return this.guardianContactNumber;
    }
}
