module vidmot.interviewtrainer {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;

    opens vidmot to javafx.fxml;
    exports vidmot;
}
