module mx.gob.telecomm.soporte.application {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

    opens mx.gob.telecomm.soporte.application to javafx.fxml;
    exports mx.gob.telecomm.soporte.application;
    exports mx.gob.telecomm.soporte.controller to javafx.fxml;
    opens mx.gob.telecomm.soporte.controller to javafx.fxml;
}
