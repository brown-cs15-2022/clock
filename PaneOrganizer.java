package clock;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import java.util.Date;


public class PaneOrganizer {
  private VBox root;
  private Label label;

  public PaneOrganizer() {
    this.root = new VBox();
    this.label = new Label();
    this.root.getChildren().add(this.label);
    this.setupTimeline();
  }

  public VBox getRoot() {
    return this.root;
  }

  private void setupTimeline() {
    KeyFrame kf = new KeyFrame(Duration.seconds(1),
                              (ActionEvent e) -> this.updateLabel());
    Timeline timeline = new Timeline(kf);
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }

  private void updateLabel() {
    Date now = new Date();
    this.label.setText(now.toString());
  }

}
