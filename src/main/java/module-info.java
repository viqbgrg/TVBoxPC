module com.github.viqbgrg.tvbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires atlantafx.base;
    requires okhttp3;
    requires org.slf4j;
    requires static lombok;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    opens com.github.viqbgrg.tvbox to javafx.fxml,spring.core;
    opens com.github.viqbgrg.tvbox.config to spring.core,spring.beans,spring.context;
    opens com.github.viqbgrg.tvbox.service to spring.core,spring.beans,spring.context;
    opens com.github.viqbgrg.tvbox.model to com.google.gson;
    exports com.github.viqbgrg.tvbox;
}