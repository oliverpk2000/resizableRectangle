module rectangle.resizablerectangle {
  requires javafx.controls;
  requires javafx.fxml;


  opens rectangle.resizablerectangle to javafx.fxml;
  exports rectangle.resizablerectangle;
}
