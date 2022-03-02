package Exercise35_Lesson3;

public class Student {
    private String id;  //,mã sinh viên
    private FullName fullName;  //họ tên sinh viên
    private String address; //địa chỉ
    private String email;   //emaill
    private String gender;  //giới tính
    private String numberPhone; //số điện thoại
    private String className;  //tên lớp
    private String major;   //khoa

    public Student(Student student) {
        id = "";
        fullName = new FullName();
        address = "";
        email = "";
        gender = "";
        numberPhone = "";
        className = "";
        major = "";
        fullName.last = "";
        fullName.frist = "";
        fullName.mid = "";

    }

    public Student(String id) {
        this.id = id;
        fullName = new FullName();
    }

    public Student(String id, String fullName) {
        this(id);
        this.setFullName(fullName);

    }

    public Student(String id, String fullName, String address) {
        this(id, fullName);
        this.setFullName(fullName);
        this.address = address;
    }

    public Student(String id, String fullName, String address, String email) {
        this(id, fullName, address);
        this.setFullName(fullName);
        this.email = email;
    }

    public Student(String id, String fullName, String address, String email, String gender) {
        this(id, fullName, address, email);
        this.setFullName(fullName);
        this.gender = gender;
    }

    public Student(String id, String fullName, String address, String email, String gender, String numberPhone) {
        this(id, fullName, address, email, gender);
        this.setFullName(fullName);
        this.numberPhone = numberPhone;
    }

    public Student(String id, String fullName, String address, String email, String gender, String numberPhone, String className) {
        this(id, fullName, address, email, gender, numberPhone);
        this.setFullName(fullName);
        this.className = className;
    }

    public Student(String id, String fullName, String address, String email, String gender, String numberPhone,
                   String className, String major) {
        this(id, fullName, address, email, gender, numberPhone, className);
        this.setFullName(fullName);
        this.major = major;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getFullName() {
        return fullName.last + " " + fullName.mid + " " + fullName.frist;
    }

    public void setFullName(String fullName) {
        var index = fullName.split(" ");
        this.fullName.last = index[0];
        this.fullName.frist = index[index.length - 1];
        this.fullName.mid = " ";
        for (int i = 1; i < index.length - 1; i++) {
            this.fullName.mid += index[i];
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    class FullName {
        private String frist;   //tên họ
        private String mid; //tên đệm
        private String last;    //tên

        public FullName() {
            frist = "";
            mid = "";
            last = "";

        }

        public FullName(String frist, String mid, String last) {
            this.frist = frist;
            this.mid = mid;
            this.last = last;
        }

        public String getFirst() {
            return fullName.frist;
        }

        public String getLast() {
            return fullName.last;
        }

        public String getMid() {
            return fullName.mid;
        }
    }


}
