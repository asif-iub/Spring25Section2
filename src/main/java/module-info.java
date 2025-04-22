module com.iub.oop.spring25section2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.librepdf.openpdf;


    opens com.iub.oop.spring25section2 to javafx.fxml;
    exports com.iub.oop.spring25section2;
}