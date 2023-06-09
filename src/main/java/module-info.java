module com.github.viqbgrg.tvbox {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires org.slf4j;
    requires static lombok;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    opens com.github.viqbgrg.tvbox to javafx.fxml,spring.core;
    exports com.github.viqbgrg.tvbox;
}