module com.github.viqbgrg.javatvbox {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens com.github.viqbgrg.javatvbox to javafx.fxml;
    exports com.github.viqbgrg.javatvbox;
}