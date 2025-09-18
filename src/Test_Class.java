public class Test_Class {
    public static void main(String[] args) {
        Student x = new Student();
        x.roll_no = 2;
        x.name = "John";

        System.out.println(x.name);
        System.out.println(x.roll_no);
    }
}
    class Student {
        int roll_no;
        String name;

}
