package Exercise35_Lesson3;

public class Subject {
    private String id;  //mã môn học
    private String name;   //tên môn học
    private int credit; //số tín chỉ
    private int numOfLesson; //số  tiết học
    private int numOfExam;  //số bài kiểm tra

    public Subject() {
        id = "";
        name = "";
        credit = 0;
        numOfExam = 0;
        numOfLesson = 0;

    }

    public Subject(String id) {
        this.id = id;
    }

    public Subject(String id, String name) {
        this(id);
        this.name = name;
    }

    public Subject(String id, String name, int credit, int numOfLesson, int numOfExam) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.numOfLesson = numOfLesson;
        this.numOfExam = numOfExam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getNumOfLesson() {
        return numOfLesson;
    }

    public void setNumOfLesson(int numOfLesson) {
        this.numOfLesson = numOfLesson;
    }

    public int getNumOfExam() {
        return numOfExam;
    }

    public void setNumOfExam(int numOfExam) {
        this.numOfExam = numOfExam;
    }
}
