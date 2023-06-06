module com.github.viqbgrg.tvbox {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens com.github.viqbgrg.tvbox to javafx.fxml;
    exports com.github.viqbgrg.tvbox;
}