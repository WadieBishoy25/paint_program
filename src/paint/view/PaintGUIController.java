package paint.view;

import paint.Controller.DrawingControl;
import paint.Controller.DrawingEngine;
import paint.Controller.ShapeSelecter;
import Paint.Model.Shape;
import Paint.Model.ShapeIntiallizer;
import Paint.Model.ShapeType;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import paint.Controller.SingleArraylistOfShapes;

public class PaintGUIController {

    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = new Point();

    Shape s;
    String Type = null;
    ShapeIntiallizer SI = new ShapeIntiallizer();
    ShapeType ST = new ShapeType();
    boolean Select = false;
    boolean Resize = false;
    boolean Remove = false;
    DrawingEngine DE = new DrawingControl();
 
    
    
    @FXML
    private AnchorPane canvas;

    @FXML
    private Pane pane;

    @FXML
    private Canvas DrawingCanvas;

    @FXML
    private Canvas DragCanvas;

    @FXML
    private Button CloseButton;

    @FXML
    private Button New;

    @FXML
    private Button Open;

    @FXML
    private Button Save;

    @FXML
    private Button Undo;

    @FXML
    private Button Redo;

    @FXML
    private Button Move;

    @FXML
    private Button resize;

    @FXML
    private Button Delete;

    @FXML
    private ColorPicker BorderColor;

    @FXML
    private Button Line;

    @FXML
    private Button Circle;

    @FXML
    private Button Square;

    @FXML
    private Button Traingle;

    @FXML
    private Button Ellipse;

    @FXML
    private Button Rectangle;

    @FXML
    private ColorPicker FillColor;

    @FXML
    private Button Refresh;

    @FXML
    void CircleButton(ActionEvent event) {
        Circle.setDisable(true);
        Rectangle.setDisable(false);
        Traingle.setDisable(false);
        Square.setDisable(false);
        Ellipse.setDisable(false);
        Line.setDisable(false);

        Type = "circle";
        Remove = false;
        Resize = false;
        Select = false;
    }

    @FXML
    void Close(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    void DeleteButton(ActionEvent event) {
        RefreshButton(event);

        Remove = true;
        Resize = false;
        Select = false;
    }

    @FXML
    void Drag(MouseEvent event) {
        p2.setLocation(event.getX(), event.getY());

        GraphicsContext GD = DragCanvas.getGraphicsContext2D();
        GD.clearRect(0, 0, 930, 542);
        if (!Remove) {
            if (Resize && s != null) {

                if (ST.getType(s).equals("circle")) {
                    p3.setLocation(s.getPosition().getX() + s.getProperties().get("radius") - Math.abs(p2.getX() - s.getPosition().getX()), s.getPosition().getY() + s.getProperties().get("radius") - Math.abs(p2.getX() - s.getPosition().getX()));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()))).draw(GD);
                }
                if (ST.getType(s).equals("square")) {
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()))).draw(GD);
                }
                if (ST.getType(s).equals("rectangle")) {
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()), Math.abs(p2.getY() - s.getPosition().getY()))).draw(GD);
                }
                if (ST.getType(s).equals("ellipse")) {
                    p3.setLocation(s.getPosition().getX() + s.getProperties().get("radius1") - Math.abs(p2.getX() - s.getPosition().getX()), s.getPosition().getY() + s.getProperties().get("radius2") - Math.abs(p2.getY() - s.getPosition().getY()));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()), Math.abs(p2.getY() - s.getPosition().getY()))).draw(GD);
                }
                if (ST.getType(s).equals("line")) {
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), p2.getX(), p2.getY())).draw(GD);
                }
                if (ST.getType(s).equals("triangle")) {
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), p2.getX() + s.getProperties().get("x2") - p1.getX(), s.getPosition().getY(), (p2.getX() + p1.getX()) / 2 + s.getProperties().get("x3") - p1.getX(), p2.getY() + s.getProperties().get("y3") - p1.getY())).draw(GD);
                }

            } else if (Select && s != null) {

                if (ST.getType(s).equals("circle")) {
                    p3.setLocation(p2.getX() - s.getProperties().get("radius"), p2.getY() - s.getProperties().get("radius"));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()).draw(GD);
                }
                if (ST.getType(s).equals("square")) {
                    p3.setLocation(p2.getX() - (s.getProperties().get("side") / 2), p2.getY() - (s.getProperties().get("side") / 2));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()).draw(GD);
                }
                if (ST.getType(s).equals("rectangle")) {
                    p3.setLocation(p2.getX() - (s.getProperties().get("width") / 2), p2.getY() - (s.getProperties().get("height") / 2));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()).draw(GD);
                }
                if (ST.getType(s).equals("ellipse")) {
                    p3.setLocation(p2.getX() - s.getProperties().get("radius1"), p2.getY() - s.getProperties().get("radius2"));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()).draw(GD);
                }
                if (ST.getType(s).equals("line")) {
                    p3.setLocation((p2.getX() - p1.getX() + s.getPosition().getX()), (p2.getY() - p1.getY() + s.getPosition().getY()));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), s.getProperties().get("EndX") + p2.getX() - p1.getX(), s.getProperties().get("EndY") + p2.getY() - p1.getY())).draw(GD);
                }
                if (ST.getType(s).equals("triangle")) {
                    p3.setLocation((s.getPosition().getX() + p2.getX() - p1.getX()), (s.getPosition().getY() + p2.getY() - p1.getY()));
                    SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), s.getProperties().get("x2") + p2.getX() - p1.getX(), s.getProperties().get("y2") + p2.getY() - p1.getY(), s.getProperties().get("x3") + p2.getX() - p1.getX(), s.getProperties().get("y3") + p2.getY() - p1.getY())).draw(GD);
                }

            } else if (Type != null && !Select && !Resize) {
                DragCanvas.setVisible(true);

                Color Border = new Color((float) BorderColor.getValue().getRed(), (float) BorderColor.getValue().getGreen(), (float) BorderColor.getValue().getBlue(), (float) BorderColor.getValue().getOpacity());
                Color Fill = new Color((float) FillColor.getValue().getRed(), (float) FillColor.getValue().getGreen(), (float) FillColor.getValue().getBlue(), (float) FillColor.getValue().getOpacity());

                if (Type.equals("circle")) {
                    p3.setLocation(p1.getX() - Math.abs(p2.getX() - p1.getX()), p1.getY() - Math.abs(p2.getX() - p1.getX()));
                    SI.getShape(Type, Border, Fill, p3.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()))).draw(GD);
                }
                if (Type.equals("square")) {
                    SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()))).draw(GD);
                }
                if (Type.equals("rectangle")) {
                    SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()))).draw(GD);
                }
                if (Type.equals("ellipse")) {
                    p3.setLocation(p1.getX() - Math.abs(p2.getX() - p1.getX()), p1.getY() - Math.abs(p2.getY() - p1.getY()));
                    SI.getShape(Type, Border, Fill, p3.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()))).draw(GD);
                }
                if (Type.equals("line")) {
                    SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, p2.getX(), p2.getY())).draw(GD);
                }
                if (Type.equals("triangle")) {
                    SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, p2.getX(), p1.getY(), (p2.getX() + p1.getX()) / 2, p2.getY())).draw(GD);
                }

            }
        }
    }

    @FXML
    void EllipseButton(ActionEvent event) {
        Ellipse.setDisable(true);
        Rectangle.setDisable(false);
        Traingle.setDisable(false);
        Square.setDisable(false);
        Circle.setDisable(false);
        Line.setDisable(false);

        Type = "ellipse";
        Remove = false;
        Resize = false;
        Select = false;

    }

    @FXML
    void LineButton(ActionEvent event) {
        Line.setDisable(true);
        Rectangle.setDisable(false);
        Traingle.setDisable(false);
        Square.setDisable(false);
        Ellipse.setDisable(false);
        Circle.setDisable(false);

        Type = "line";
        Remove = false;
        Resize = false;
        Select = false;
    }

    @FXML
    void MoveButton(ActionEvent event) {
        RefreshButton(event);

        Remove = false;
        Resize = false;
        Select = true;
    }

    @FXML
    void NewButton(ActionEvent event) {
        RefreshButton(event);
        
        GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
                GC.clearRect(0, 0, 930, 542);
        ArrayList<Shape> A = new ArrayList<Shape>();
        SingleArraylistOfShapes.setInstance(A);
        
    }

    @FXML
    void OpenButton(ActionEvent event) {
        RefreshButton(event);

        FileChooser Chooser = new FileChooser();
        Chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.JSON"));
        Chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML files (*.xml)", "*.XML"));
        
        DE.load(Chooser.showOpenDialog(null).getAbsolutePath());
        
        GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
                    GC.clearRect(0, 0, 930, 542);
                    DE.refresh(GC);
    }

    @FXML
    void Press(MouseEvent event) {
        if (Remove) {
            ShapeSelecter SS = new ShapeSelecter();
            s = SS.Select(event.getX(), event.getY());
            if (s != null) {
                DE.removeShape(s);

                GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
                GC.clearRect(0, 0, 930, 542);
                DE.refresh(GC);
            }
        } else {

            if (Select || Resize) {
                ShapeSelecter SS = new ShapeSelecter();
                s = SS.Select(event.getX(), event.getY());

                if (s != null) {
                    DragCanvas.setVisible(true);
                    GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
                    GC.clearRect(0, 0, 930, 542);
                    DE.refresh(GC);
                    GraphicsContext GD = DragCanvas.getGraphicsContext2D();
                    s.draw(GD);

                }

            }

            p1.setLocation(event.getX(), event.getY());

        }

    }

    @FXML
    void RectangleButton(ActionEvent event) {
        Rectangle.setDisable(true);
        Circle.setDisable(false);
        Traingle.setDisable(false);
        Square.setDisable(false);
        Ellipse.setDisable(false);
        Line.setDisable(false);

        Type = "rectangle";
        Remove = false;
        Resize = false;
        Select = false;
    }

    @FXML
    void RedoButton(ActionEvent event) {
        RefreshButton(event);
        DE.redo();
        GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
        GC.clearRect(0, 0, 930, 542);
        DE.refresh(GC);
    }

    @FXML
    void RefreshButton(ActionEvent event) {
        Rectangle.setDisable(false);
        Traingle.setDisable(false);
        Square.setDisable(false);
        Ellipse.setDisable(false);
        Circle.setDisable(false);
        Line.setDisable(false);

        Type = null;
    }

    @FXML
    void Relesae(MouseEvent event) {

        GraphicsContext GD = DragCanvas.getGraphicsContext2D();
        GD.clearRect(0, 0, 930, 542);
        DragCanvas.setVisible(false);

        if (!Remove) {
            if (Resize && s != null) {
                if (ST.getType(s).equals("circle")) {
                    p3.setLocation(s.getPosition().getX() + s.getProperties().get("radius") - Math.abs(p2.getX() - s.getPosition().getX()), s.getPosition().getY() + s.getProperties().get("radius") - Math.abs(p2.getX() - s.getPosition().getX()));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()))));
                }
                if (ST.getType(s).equals("square")) {
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()))));
                }
                if (ST.getType(s).equals("rectangle")) {
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()), Math.abs(p2.getY() - s.getPosition().getY()))));
                }
                if (ST.getType(s).equals("ellipse")) {
                    p3.setLocation(s.getPosition().getX() + s.getProperties().get("radius1") - Math.abs(p2.getX() - s.getPosition().getX()), s.getPosition().getY() + s.getProperties().get("radius2") - Math.abs(p2.getY() - s.getPosition().getY()));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), Math.abs(p2.getX() - s.getPosition().getX()), Math.abs(p2.getY() - s.getPosition().getY()))));
                }
                if (ST.getType(s).equals("line")) {
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), p2.getX(), p2.getY())));
                }
                if (ST.getType(s).equals("triangle")) {
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), s.getPosition(), SI.setProperties(ST.getType(s), p2.getX() + s.getProperties().get("x2") - p1.getX(), s.getPosition().getY(), (p2.getX() + p1.getX()) / 2 + s.getProperties().get("x3") - p1.getX(), p2.getY() + s.getProperties().get("y3") - p1.getY())));
                }

            } else if (Select && s != null) {

                if (ST.getType(s).equals("circle")) {
                    p3.setLocation(p2.getX() - s.getProperties().get("radius"), p2.getY() - s.getProperties().get("radius"));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()));
                }
                if (ST.getType(s).equals("square")) {
                    p3.setLocation(p2.getX() - (s.getProperties().get("side") / 2), p2.getY() - (s.getProperties().get("side") / 2));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()));
                }
                if (ST.getType(s).equals("rectangle")) {
                    p3.setLocation(p2.getX() - (s.getProperties().get("width") / 2), p2.getY() - (s.getProperties().get("height") / 2));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()));
                }
                if (ST.getType(s).equals("ellipse")) {
                    p3.setLocation(p2.getX() - s.getProperties().get("radius1"), p2.getY() - s.getProperties().get("radius2"));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), s.getProperties()));
                }
                if (ST.getType(s).equals("line")) {
                    p3.setLocation((p2.getX() - p1.getX() + s.getPosition().getX()), (p2.getY() - p1.getY() + s.getPosition().getY()));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), s.getProperties().get("EndX") + p2.getX() - p1.getX(), s.getProperties().get("EndY") + p2.getY() - p1.getY())));
                }
                if (ST.getType(s).equals("triangle")) {
                    p3.setLocation((s.getPosition().getX() + p2.getX() - p1.getX()), (s.getPosition().getY() + p2.getY() - p1.getY()));
                    DE.updateShape(s, SI.getShape(ST.getType(s), s.getColor(), s.getFillColor(), p3.getLocation(), SI.setProperties(ST.getType(s), s.getProperties().get("x2") + p2.getX() - p1.getX(), s.getProperties().get("y2") + p2.getY() - p1.getY(), s.getProperties().get("x3") + p2.getX() - p1.getX(), s.getProperties().get("y3") + p2.getY() - p1.getY())));
                }

            } else if (Type != null && !Select && !Resize) {

                Color Border = new Color((float) BorderColor.getValue().getRed(), (float) BorderColor.getValue().getGreen(), (float) BorderColor.getValue().getBlue(), (float) BorderColor.getValue().getOpacity());
                Color Fill = new Color((float) FillColor.getValue().getRed(), (float) FillColor.getValue().getGreen(), (float) FillColor.getValue().getBlue(), (float) FillColor.getValue().getOpacity());

                if (Type.equals("circle")) {
                    p3.setLocation(p1.getX() - Math.abs(p2.getX() - p1.getX()), p1.getY() - Math.abs(p2.getX() - p1.getX()));
                    DE.addShape(SI.getShape(Type, Border, Fill, p3.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()))));
                }
                if (Type.equals("square")) {
                    DE.addShape(SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()))));
                }
                if (Type.equals("rectangle")) {
                    DE.addShape(SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()))));
                }
                if (Type.equals("ellipse")) {
                    p3.setLocation(p1.getX() - Math.abs(p2.getX() - p1.getX()), p1.getY() - Math.abs(p2.getY() - p1.getY()));
                    DE.addShape(SI.getShape(Type, Border, Fill, p3.getLocation(), SI.setProperties(Type, Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()))));
                }
                if (Type.equals("line")) {
                    DE.addShape(SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, p2.getX(), p2.getY())));
                }
                if (Type.equals("triangle")) {
                    DE.addShape(SI.getShape(Type, Border, Fill, p1.getLocation(), SI.setProperties(Type, p2.getX(), p1.getY(), (p2.getX() + p1.getX()) / 2, p2.getY())));
                }

            }
            GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
            GC.clearRect(0, 0, 930, 542);
            DE.refresh(GC);

        }
    }

    @FXML
    void ResizeButton(ActionEvent event) {
        RefreshButton(event);

        Remove = false;
        Resize = true;
        Select = false;
    }

    @FXML
    void SaveButton(ActionEvent event) {
        RefreshButton(event);

        FileChooser Chooser = new FileChooser();
        Chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.JSON"));
        Chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML files (*.xml)", "*.XML"));
        
        DE.save(Chooser.showSaveDialog(null).getAbsolutePath());
   
    }

    @FXML
    void SquareButton(ActionEvent event) {
        Square.setDisable(true);
        Rectangle.setDisable(false);
        Traingle.setDisable(false);
        Circle.setDisable(false);
        Ellipse.setDisable(false);
        Line.setDisable(false);

        Type = "square";
        Remove = false;
        Resize = false;
        Select = false;
    }

    @FXML
    void TriangleButton(ActionEvent event) {
        Traingle.setDisable(true);
        Circle.setDisable(false);
        Square.setDisable(false);
        Ellipse.setDisable(false);
        Rectangle.setDisable(false);
        Line.setDisable(false);

        Type = "triangle";
        Remove = false;
        Resize = false;
        Select = false;
    }

    @FXML
    void UndoButton(ActionEvent event) {
        RefreshButton(event);
        DE.undo();
        GraphicsContext GC = DrawingCanvas.getGraphicsContext2D();
        GC.clearRect(0, 0, 930, 542);
        DE.refresh(GC);
    }

    
}
