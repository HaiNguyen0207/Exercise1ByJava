package Exercise35_Lesson3;

public class Transcript {

    private float grade1;
    private float grade2;
    private float grade3;
    private float gpa;
    private Capacity capacity;

    public Transcript() {
        grade3 = 0f;
        grade2 = 0f;
        grade1 = 0f;
        gpa = 0f;
        capacity = null;

    }

    public Transcript(float grade1, float grade2, float grade3) {
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public Transcript(float grade1, float grade2, float grade3, float gpa) {
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.gpa = gpa;
    }

    public Transcript(float grade1, float grade2, float grade3, float gpa, Capacity capacity) {
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.gpa = gpa;
        this.capacity = capacity;
    }


    public float getGrade1() {
        return grade1;
    }

    public void setGrade1(float grade1) {
        this.grade1 = grade1;
    }

    public float getGrade2() {
        return grade2;
    }

    public void setGrade2(float grade2) {
        this.grade2 = grade2;
    }

    public float getGrade3() {
        return grade3;
    }

    public void setGrade3(float grade3) {
        this.grade3 = grade3;
    }

    public float getGpa() {
        return gpa;
    }

    public float setGpa() {
        gpa = (this.grade1 + grade2 * 2 + grade3 * 3) / 6;
        return gpa;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public void calculGpa() {
        this.gpa= (grade1 + grade2 * 2 + grade3 * 3) / 6;
    }

    public void calculCapacity() {
        if (gpa >= 9.0f) {
            capacity = Capacity.A_Plus;
        } else if (gpa >= 8.0f) {
            capacity = Capacity.A;
        } else if (gpa >= 6.5f) {
            capacity = Capacity.B;
        } else if (gpa >= 5.0f) {
            capacity = Capacity.C;
        } else if (gpa >= 4.0f) {
            capacity = Capacity.F;
        } else {
            capacity = Capacity.F;

        }

    }
}
