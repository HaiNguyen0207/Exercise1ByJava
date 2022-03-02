package Exercise35_Lesson3;

public enum Capacity {
    F("Trượt"), D("Yếu"), C("Trung Bình"), B("Khá"), A("Giỏi"), A_Plus("Xuất Xắc");

    Capacity(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
