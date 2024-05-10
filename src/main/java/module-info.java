module music.spotify {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.sql;
    requires java.persistence;
    requires java.naming;
    requires jakarta.mail;
    requires javafx.media;
    requires java.desktop;

    opens DTO to org.hibernate.orm.core;


    exports GUI;
    opens GUI to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
}