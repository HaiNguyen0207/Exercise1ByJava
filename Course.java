package Exercise35_Lesson3;

import java.util.ArrayList;

public class Course {
    private String id;  //mã lớp
    private String name;    //tên lớp
    private String classRom;    //phòng học
    private String time;    //giờ học
    private Subject subject;
    private ArrayList<TranscriptOfStudents> transcriptOfStudents;  //bảng điểm sinh viên

    public Course() {
        id = "";
        name = "";
        classRom = "";
        time = "";
        subject = null;
        transcriptOfStudents = new ArrayList<>();

    }

    public Course(String id, String name, String classRom, String time, Subject subject) {
        transcriptOfStudents = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.classRom = classRom;
        this.time = time;
        this.subject = subject;
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

    public String getClassRom() {
        return classRom;
    }

    public void setClassRom(String classRom) {
        this.classRom = classRom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ArrayList<TranscriptOfStudents> getTranscriptOfStudents() {
        return transcriptOfStudents;
    }

    public void setTranscriptOfStudents(Student student, Transcript transcript) {
        for (int i = 0; i < transcriptOfStudents.size(); i++) {
            if (transcriptOfStudents.get(i).student.getId().compareToIgnoreCase(student.getId()) == 0) {
                transcriptOfStudents.get(i).transcript = transcript;
                break;
            }

        }
    }

    public void addStudentInCourse(Student student) {
        transcriptOfStudents.add(new TranscriptOfStudents(student, null));
    }


    public class TranscriptOfStudents {
        private Student student;
        private Transcript transcript;

        public TranscriptOfStudents() {
            student = null;
            transcript = null;
        }

        public TranscriptOfStudents(Student student, Transcript transcript) {
            this.student = student;
            this.transcript = transcript;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Transcript getTranscript() {
            return transcript;
        }

        public void setTranscript(Transcript transcript) {
            this.transcript = transcript;
        }
    }

}
