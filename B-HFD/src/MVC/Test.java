package MVC;

public class Test {
    public static void main(String[] args) {

        // 从数据可获取学生记录
        StudentModel model = retriveStudentFromDatabase();

        // 创建一个视图：把学生信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // 更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }

    private static StudentModel retriveStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
