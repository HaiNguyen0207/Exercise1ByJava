package Exercise35_Lesson3;


import java.util.ArrayList;
import java.util.Scanner;


public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Capacity> capacities = new ArrayList<>();
        ArrayList<Transcript> transcript = new ArrayList<>();
        Transcript transcripts = new Transcript();
        createNewStudents(students);
        createNewSubjects(subjects);
        createNewCourses(courses, subjects);
        var choice = 0;
        do {
            System.out.println("=================================MENU===============================");
            System.out.println("= 1. Thêm mới môn học vào danh sách môn học                        =");
            System.out.println("= 2. Thêm mới một sinh viên vào danh sách sinh viên                =");
            System.out.println("= 3. Thêm mới một lớp học vào danh sách lớp học                    =");
            System.out.println("= 4. Thêm sinh viên vào lớp học bằng cách nhập mã lớp ,nhập mã SV  =");
            System.out.println("= 5. Hiển thị danh sách môn học                                    =");
            System.out.println("= 6. Hiển thị danh sách sinh viên                                  =");
            System.out.println("= 7. Hiển thị danh sách lớp học                                    =");
            System.out.println("= 8. Nhập điểm và tính điểm trung bình cho từng sinh viên          =");
            System.out.println("= 9. Xét học lực cho từng sinh viên                                =");
            System.out.println("= 10. Tìm sinh viên với mã cho trước có ở trong lớp hay không      =");
            System.out.println("= 11. Hiển thị bảng điểm ,học lực tương ứng của từng sinh viên     =");
            System.out.println("= 0. Kết thúc chương trình                                         =");
            System.out.println("====================================================================");
            System.out.println("======================> Nhập lựa chọn của bạn <=====================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("========> Chương trình kết thúc ! Hẹn gặp lại <========");
                    break;
                case 1:
                    var sub = createNewSubject(input);
                    subjects.add(sub);
                    System.out.println("==============> Thêm môn học thành công <=============");
                    break;
                case 2:
                    var student = createNewStudent(input);
                    students.add(student);
                    System.out.println("==============> Thêm sinh viên thành công <=============");
                    break;
                case 3:
                    var isSuccess = creteNewCourse(input, courses, subjects);
                    if (isSuccess) {
                        System.out.println("==============> Thêm mới lớp học thành công <===========");
                    } else {
                        System.out.println("===============> Thêm mới lớp học thất bại <=============");
                    }
                    break;
                case 4:
                    if (courses.size() > 0 && students.size() > 0) {
                        var s = addStudentToCourse(courses, students, input);
                        if (s) {
                            System.out.println("===========> Thêm sinh viên vào lớp thành công <==========");
                        } else {
                            System.out.println("===========> Thêm sinh viên vào lớp thất bại <===========");
                        }
                    } else {
                        System.out.println("=======> Danh sách lớp học hoặc sinh viên rỗng <=========");
                    }
                    break;
                case 5:
                    if (subjects.size() > 0) {
                        showSubjects(subjects);
                    } else {
                        System.out.println("================> Danh sách môn học rỗng <==============");
                    }
                    break;
                case 6:
                    if (students.size() > 0) {
                        showStudents(students);
                    } else {
                        System.out.println("================> Danh sách sinh viên rỗng <=============");
                    }
                    break;
                case 7:
                    if (courses.size() > 0) {
                        showCourses(courses);
                    } else {
                        System.out.println("===============> Danh sách lớp học rỗng <===============");
                    }
                    break;
                case 8:
                    if (courses.size() > 0) {
                        var s = calculTranscriptOfStudent(courses, input, transcripts);
                        if (s) {
                            System.out.println("========> Xét bảng điểm sinh viên thành công <======");
                        } else {
                            System.out.println("========> Xét bảng điểm sinh viên thất bại <=========");
                        }
                    } else {
                        System.out.println("=============> Danh sách lớp học rỗng <===============");
                    }
                    break;
                case 9:
                    if (courses.size() > 0) {
                        var s = capacityOfStudent(courses, input);
                        if (s) {
                            System.out.println("===========> Xét học lực sinh viên thành công <=============");
                        } else {
                            System.out.println("===========> Xét học lực sinh viên phòng thất bại <==========");
                        }
                    } else {
                        System.out.println("=============> Danh sách lớp học rỗng <============");
                    }
                    break;
                case 10:
                    if (courses.size() > 0 && students.size() > 0) {
                        var result = findStudentInCourse(courses, students, input);
                        if (result.size() > 0) {
                            showStudents(result);
                        } else {
                            System.out.println("======> Không tìm thấy sinh viên này trong phòng nào <=====");
                        }
                    } else {
                        System.out.println("====> Danh sách lớp học hoặc danh sách sinh viên rỗng <=====");
                    }
                    break;
                case 11:
                    if (courses.size() > 0) {
                        showCapacity(courses, input);
                    } else {
                        System.out.println("==========> Danh sách lớp học rỗng <==========");
                    }
                    break;
                default:
                    System.out.println("======> Sai chức năng .Vui lòng nhập lại <=======");
                    break;
            }
        } while (choice != 0);
    }

    private static void showCapacity(ArrayList<Course> courses, Scanner input) {
        System.out.println("Nhập  mã lớp hiển thị học lực sinh viên : ");
        input.nextLine();
        var courseId = input.nextLine();
        var course = findCourseById(courses, courseId);
        if (course != null) {
            System.out.printf("%-20s%-20s%-15s%-15s%-15s%-15s%-20s\n", "Mã SV", "Họ Tên", "Điểm hs1", "Điểm hs2",
                    "Điểm hs3", "Điểm TB", "Họ Lực");
            for (var s : course.getTranscriptOfStudents()) {
                showS(s);
            }
        }
        System.out.println("=============> Mã lớp không tồn tại <================");
    }

    private static void showS(Course.TranscriptOfStudents s) {
        System.out.printf("%-20s%-20s%-15.2f%-15.2f%-15.2f%-15.2f%-20s\n", s.getStudent().getId(),
                s.getStudent().getFullName(), s.getTranscript().getGrade1(), s.getTranscript().getGrade2(),
                s.getTranscript().getGrade3(), s.getTranscript().getGpa(), s.getTranscript().getCapacity());
    }

    /**
     * phương thức tìm kiếm sinh viên đã xuất hiện trong lớp chưa
     *
     * @param courses  danh sách lớp học gốc
     * @param students danh sách sinh viên gốc
     * @param input    đồi tượng scanner
     * @return arrayList chứa sinh viên tìm
     */
    private static ArrayList<Student> findStudentInCourse(ArrayList<Course> courses, ArrayList<Student> students,
                                                          Scanner input) {
        ArrayList<Student> s = new ArrayList<>();
        System.out.println("Nhập mã sinh viên cần tìm : ");
        input.nextLine();
        var studentId = input.nextLine();
        var student = findStudentById(students, studentId);
        if (student != null) {
            for (int i = 0; i < courses.size(); i++) {
                var x = courses.get(i).getTranscriptOfStudents();
                for (var a : x) {
                    if (a.getStudent().getId().compareToIgnoreCase(studentId) == 0) {
                        s.add(a.getStudent());
                        System.out.println("=====> Tìm thấy sinh viên trong phòng : " + courses.get(i).getClassRom() + " <====");
                        break;
                    }
                }
            }
        }
        return s;
    }

    /**
     * phương thức xét học lực của sinh viên
     *
     * @param courses danh sách lớp học rỗng
     * @param input   đối tượng lớp scanner
     * @return true nếu xét học lực thành công , false ngược lại
     */
    private static boolean capacityOfStudent(ArrayList<Course> courses, Scanner input) {
        System.out.println("Nhập mã lớp xét học lực : ");
        input.nextLine();
        var courseId = input.nextLine();
        var course = findCourseById(courses, courseId);
        if (course != null) {
            if (course.getTranscriptOfStudents().size() > 0) {
                for (var s : course.getTranscriptOfStudents()) {
                    if (s.getTranscript() != null) {
                        s.getTranscript().calculCapacity();
                    } else {
                        System.out.println("=====> Chưa cập nhật hết bảng điểm sinh viên <======");
                        return false;
                    }
                }
                return true;
            } else {
                System.out.println("===========> Sinh viên chưa có trong lớp <==========");
                return false;
            }
        }

        System.out.println("================> Mã lớp không hợp lệ <==================");
        return false;
    }

    /**
     * phương thức tính điểm của sinh viên trong lớp
     *
     * @param courses     danh sách lớp học gốc
     * @param input       đối tượng lớp scanner
     * @param transcripts bảng điểm gốc
     * @return true nếu tính điểm thành công ,false nếu ngược lại
     */
    private static boolean calculTranscriptOfStudent(ArrayList<Course> courses, Scanner input,
                                                     Transcript transcripts) {
        System.out.println("Nhập mã lớp tính điểm sinh viên : ");
        input.nextLine();
        var courseId = input.nextLine();
        var course = findCourseById(courses, courseId);
        if (course != null) {
            if (course.getTranscriptOfStudents().size() == 0) {
                System.out.println("========> Lớp học chưa có sinh viên .Vui lòng thêm sinh viên vô lớp <=====");
                return false;
            } else {
                for (var s : course.getTranscriptOfStudents()) {
                    System.out.println("Nhập điểm sinh viên : " + s.getStudent().getFullName());
                    System.out.println("Nhập điểm hệ số 1 : ");
                    var g1 = Float.parseFloat(input.nextLine());
                    System.out.println("Nhập điểm hệ số 2 : ");
                    var g2 = Float.parseFloat(input.nextLine());
                    System.out.println("Nhập điểm hệ số 3 : ");
                    var g3 = Float.parseFloat(input.nextLine());
                    transcripts.setGrade1(g1);
                    transcripts.setGrade2(g2);
                    transcripts.setGrade3(g3);
                    transcripts.calculGpa();

                    course.setTranscriptOfStudents(new Student(s.getStudent().getId()), new Transcript(transcripts.getGrade1(),
                            transcripts.getGrade2(), transcripts.getGrade3(), transcripts.getGpa()));
                    System.out.println("=====> Nhập điểm sinh viên " + s.getStudent().getFullName() + " thành công <====");
                }
                return true;
            }

        }


        System.out.println("============> Mã lớp không tồn tại <===============");
        return false;
    }


    /**
     * phương thức thêm sinh viên vào lớp học
     * kiểm tra xem mã lớp vs mã sinh viên có tồn tại không
     *
     * @param courses  danh sách lớp học gốc
     * @param students dánh sách sinh viên gốc
     * @param input    đối tượng lớp scanner
     * @return true nếu thêm thành công và ngược lại
     */
    private static boolean addStudentToCourse(ArrayList<Course> courses, ArrayList<Student> students, Scanner
            input) {
        System.out.println("Nhập mã lớp : ");
        input.nextLine();
        var courseId = input.nextLine();
        var course = findCourseById(courses, courseId);
        if (course != null) {
            System.out.println("=========> Danh sách sinh viên đã có trong lớp " + course.getName() + " <=====");
            showStudentInCourse(course.getTranscriptOfStudents());
            System.out.println("Nhập mã sinh viên cần thêm : ");
            var studentId = input.nextLine();
            var student = findStudentById(students, studentId);
            if (student != null) {
                // sinh viên xuất hiện trong lớp khác
                var s1 = findStudentAppearInCourse(courses, studentId, courseId);
                var s2 = searchStudentAppearInCourse(course, studentId);
                if (s2 == true) {
                    System.out.println("=====> Sinh viên : " + student.getFullName() + " " +
                            "có trong lớp .Vui lòng xem lại <=====");
                    return false;
                } else {
                    if (s1 == null && s2 == false) {
                        course.addStudentInCourse(student);
                        return true;
                    } else {
                        System.out.println("=====> Sinh viên : " + student.getFullName() + " đã có trong phòng "
                                + s1.getId() + " <=====");
                        return false;
                    }
                }
            } else {
                System.out.println("===========> Mã sinh viên không tồn tại <============");
                return false;

            }
        }
        System.out.println("============> Mã lớp học không tồn tại <===========");
        return false;

    }

    /**
     * phương thức kiểm tra xem sinh viên đã xuất hiện trong lớp chưa
     *
     * @param course    lớp chứa sinh viên
     * @param studentId mã sinh viên cần kiểm tra
     * @return true nếu xuất hiện rồi ,flase nếu chưa
     */
    private static boolean searchStudentAppearInCourse(Course course, String studentId) {
        if (course(course.getTranscriptOfStudents(), studentId)) {
            return true; //xuất hiện rồi
        }
        return false; //chưa xuất hiện
    }

    /**
     * phương thức kiểm tra sinh viên đã xuất hiện trong lớp học nào chưa
     *
     * @param courses   danh sách lớp học gốc
     * @param studentId mã sinh viên cần kiểm tra
     * @param courseId  mã lớp học
     * @return lớp học sinh viên xuất hiện
     */
    private static Course findStudentAppearInCourse(ArrayList<Course> courses, String studentId, String courseId) {
        for (var s : courses) {
            if (s.getId().compareToIgnoreCase(courseId) != 0) {
                if (course(s.getTranscriptOfStudents(), studentId)) {
                    return s;
                }
            }
        }
        return null;    //chưa xuất hiện
    }

    private static boolean course(ArrayList<Course.TranscriptOfStudents> transcriptOfStudents, String id) {
        for (var s : transcriptOfStudents) {
            if (s.getStudent().getId().compareToIgnoreCase(id) == 0) {
                return true; //xuất hiện rồi !
            }
        }
        return false;   //chưa xuất hiện
    }


    /**
     * phương thức tìm kiếm mã sinh viên có tồn tại hay không ?
     *
     * @param students  danh sách sinh viên gốc
     * @param studentId mã nhân viên cần tìm kiếm
     * @return student nếu có ,null nếu không
     */
    private static Student findStudentById(ArrayList<Student> students, String studentId) {
        for (var student : students) {
            if (student.getId().compareToIgnoreCase(studentId) == 0) {
                return student;
            }
        }
        return null;
    }

    /**
     * hiển thị sinh viên trong lớp học
     *
     * @param transcriptOfStudents danh sách sinh viên cùng bảng điểm gốc
     */
    private static void showStudentInCourse(ArrayList<Course.TranscriptOfStudents> transcriptOfStudents) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s\n", "Mã SV", "Họ tên", "Địa chỉ", "Email", "Giới tính",
                "Số đt", "Lớp", "Khoa");
        for (var studentInCourse : transcriptOfStudents) {
            showStudent(studentInCourse.getStudent());
        }
    }

    /**
     * phương thức kiểm tra mã lớp có tồn tại không ?
     *
     * @param courses  danh sách lớp học gốc
     * @param courseId mã lớp cần kiểm tra
     * @return course nếu tồn tại ,null nếu không
     */
    private static Course findCourseById(ArrayList<Course> courses, String courseId) {
        for (var course : courses) {
            if (course.getId().compareToIgnoreCase(courseId) == 0) {
                return course;
            }
        }
        return null;
    }

    /**
     * phương thức hiển thị danh sách lớp học theo dạng cột
     *
     * @param courses danh sách lớp học gốc
     */
    private static void showCourses(ArrayList<Course> courses) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Mã lớp", "Tên lớp", "Phòng học", "Giờ học", "Môn học");
        for (var course : courses) {
            showCourse(course);
        }
    }

    /**
     * phương thức hiển thị 1 lớp học dạng cột
     *
     * @param course lớp học cần hiển thị
     */
    private static void showCourse(Course course) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", course.getId(), course.getName(), course.getClassRom(),
                course.getTime(), course.getSubject().getName());
    }

    /**
     * phương thức hiển thị dánh sách sinh viên
     *
     * @param students danh  sách sinh viên gốc
     */
    private static void showStudents(ArrayList<Student> students) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s\n", "Mã SV", "Họ tên", "Địa chỉ", "Email", "Giới tính",
                "Số đt", "Lớp", "Khoa");
        for (var student : students) {
            showStudent(student);
        }
    }

    /**
     * phương thức hiển thị một sinh viên dạng cột
     *
     * @param s sinh viên cần được hiển thị
     */
    private static void showStudent(Student s) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s\n", s.getId(), s.getFullName(), s.getAddress(),
                s.getEmail(), s.getGender(), s.getNumberPhone(), s.getClassName(), s.getMajor());
    }

    /**
     * phương thức hiển thị danh sách môn học
     *
     * @param subjects danh sách môn học gốc
     */
    private static void showSubjects(ArrayList<Subject> subjects) {
        System.out.printf("%-20s%-20s%-15s%-15s%-15s\n", "Mã môn", "Tên môn", "Số tín", "Số tiết", "Số kt");
        for (var subject : subjects) {
            showSubject(subject);
        }
    }

    /**
     * phương thức hiển thị 1 môn học theo dạng cột
     *
     * @param subject môn học cần hiển thị
     */
    private static void showSubject(Subject subject) {
        System.out.printf("%-20s%-20s%-15d%-15d%-15d\n", subject.getId(), subject.getName(), subject.getCredit(),
                subject.getNumOfLesson(), subject.getNumOfExam());
    }

    /**
     * phương thức thêm mới một lớp học
     *
     * @param input    đối tượng lớp Scanner
     * @param courses  danh sách lớp học gốc
     * @param subjects danh sách môn học gốc
     * @return true nếu tạo môn học thành công ,flase nếu ngược lại
     */
    private static boolean creteNewCourse(Scanner
                                                  input, ArrayList<Course> courses, ArrayList<Subject> subjects) {
        System.out.println("Nhập mã lớp : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập tên lớp : ");
        var name = input.nextLine();
        System.out.println("Nhập phòng học : ");
        var classRom = input.nextLine();
        System.out.println("Nhập giờ học : ");
        var time = input.nextLine();
        System.out.println("Nhập mã môn học : ");
        var subjectId = input.nextLine();
        var subject = findSubjectById(subjects, subjectId);
        if (subject != null) {
            courses.add(new Course(id, name, classRom, time, subject));
            return true;
        }
        System.out.println("===========> Mã môn học không tồn tại <===========");
        return false;
    }

    /**
     * phương thức xét mã môn có tồn tại ko
     *
     * @param subjects  danh sách môn học gốc
     * @param subjectId mã môn học cần xét
     * @return sub nếu có ,null nếu k
     */
    private static Subject findSubjectById(ArrayList<Subject> subjects, String subjectId) {
        for (var sub : subjects) {
            if (sub.getId().compareToIgnoreCase(subjectId) == 0) {
                return sub;
            }
        }
        return null;
    }

    /**
     * phương thức thêm mới sinh viên
     *
     * @param input đối tượng lớp scanner
     * @return đối tượng sinh viên vừa tạo
     */
    private static Student createNewStudent(Scanner input) {
        System.out.println("Nhập mã sinh viên : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập họ tên sinh viên : ");
        var fullName = input.nextLine();
        System.out.println("Nhập địa chỉ : ");
        var address = input.nextLine();
        System.out.println("Nhập gmail : ");
        var email = input.nextLine();
        System.out.println("Nhập giới tính : ");
        var gender = input.nextLine();
        System.out.println("Nhập số điện thoại : ");
        var phone = input.nextLine();
        System.out.println("Nhập tên lớp : ");
        var nameClass = input.nextLine();
        System.out.println("Nhập khoa : ");
        var major = input.nextLine();
        return new Student(id, fullName, address, email, gender, phone, nameClass, major);
    }

    /**
     * phương thức thêm mới môn học
     *
     * @param input đối tượng của lớp Scanner
     * @return đối tượng vừa tạo
     */
    private static Subject createNewSubject(Scanner input) {
        System.out.println("Nhập mã môn : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập tên môn : ");
        var name = input.nextLine();
        System.out.println("Nhập số tín chỉ : ");
        var credit = Integer.parseInt(input.nextLine());
        System.out.println("Nhập số tiết học : ");
        var numOfLesson = Integer.parseInt(input.nextLine());
        System.out.println("Nhập số bài kiểm tra : ");
        var numOfTest = Integer.parseInt(input.nextLine());
        return new Subject(id, name, credit, numOfLesson, numOfTest);
    }

    private static void createNewStudents(ArrayList<Student> students) {
        students.add(new Student("SV001", "Nguyễn Văn A", "Hà Nội", "a@xmail.com", "Nam",
                "1900abc1", "AT17D", "ATTT"));
        students.add(new Student("SV002", "Nguyễn Văn B", "Hà Nội", "b@xmail.com", "Nam",
                "1900abc2", "AT17D", "ATTT"));
        students.add(new Student("SV003", "Nguyễn Văn C", "Hà Nội", "c@xmail.com", "Nam",
                "1900abc3", "AT17D", "ATTT"));
        students.add(new Student("SV004", "Nguyễn Văn D", "Hà Nội", "d@xmail.com", "Nam",
                "1900abc4", "AT17D", "ATTT"));
        students.add(new Student("SV005", "Nguyễn Văn E", "Hà Nội", "e@xmail.com", "Nam",
                "1900abc5", "AT17D", "ATTT"));
    }

    private static void createNewSubjects(ArrayList<Subject> subjects) {
        subjects.add(new Subject("Java001", "Java1", 3, 12, 4));
        subjects.add(new Subject("Java002", "Java2", 3, 12, 4));
        subjects.add(new Subject("Java003", "Java3", 3, 12, 4));
        subjects.add(new Subject("Java004", "Java4", 3, 12, 4));
        subjects.add(new Subject("Java005", "Java5", 3, 12, 4));
    }

    private static void createNewCourses(ArrayList<Course> courses, ArrayList<Subject> subjects) {
        courses.add(new Course("P001", "AT17A", "300", "9h-11h", subjects.get(0)));
        courses.add(new Course("P002", "AT17B", "301", "9h-11h", subjects.get(0)));
        courses.add(new Course("P003", "AT17C", "302", "9h-11h", subjects.get(0)));
        courses.add(new Course("P004", "AT17D", "303", "9h-11h", subjects.get(0)));
        courses.add(new Course("P005", "AT17E", "304", "9h-11h", subjects.get(0)));
    }

}
