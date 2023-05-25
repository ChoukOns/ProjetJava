module Bambou {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	 exports controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	opens controller;
}
