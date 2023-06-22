package rectangle.resizablerectangle;

import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class ResizableRectangleController implements Initializable {

  @FXML
  private Label areaOutputLabel;

  @FXML
  private ChoiceBox<Color> choiceBox;

  @FXML
  private Slider lengthSlider;

  @FXML
  private Rectangle rectangle;

  @FXML
  private Slider widthSlider;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    choiceBox.getItems().add(Color.WHITE);
    choiceBox.getItems().add(Color.web("0x9cce2b"));
    choiceBox.getItems().add(Color.BLUE);
    choiceBox.getItems().add(Color.RED);
    choiceBox.getSelectionModel()
      .selectedItemProperty()
      .addListener((observableValue, oldColor, newColor) -> rectangle.setFill(newColor));
    rectangle.heightProperty().bind(lengthSlider.valueProperty());
    rectangle.widthProperty().bind(widthSlider.valueProperty());
    StringBinding area = new StringBinding() {
      {super.bind(widthSlider.valueProperty(), lengthSlider.valueProperty());}

      @Override
      protected String computeValue() {
        return String.format("%.0fE^2", widthSlider.getValue()*lengthSlider.getValue());
      }
    };
    areaOutputLabel.textProperty().bind(area);
  }
}
