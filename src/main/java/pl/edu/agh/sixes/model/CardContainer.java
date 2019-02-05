package pl.edu.agh.sixes.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

import java.util.Optional;

public class CardContainer {

    private final Place place;
    private final Optional<Coordinates> coordinates;
    private ObjectProperty<Optional<Card>> content;

    public CardContainer(Place place, Coordinates coordinates, Card card) {
        this.place = place;
        this.coordinates = Optional.ofNullable(coordinates);
        this.content = new SimpleObjectProperty<>(Optional.of(card));
    }

    public CardContainer(Place place, Coordinates coordinates) {
        this.place = place;
        this.coordinates = Optional.ofNullable(coordinates);
        this.content = new SimpleObjectProperty<>(Optional.empty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !coordinates.isPresent() || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return this.coordinates.get().rowId == coordinates.rowId &&
                this.coordinates.get().columnId == coordinates.columnId;
    }

    public Place getPlace() {
        return place;
    }

    public Optional<Coordinates> getCoordinates() {
        return coordinates;
    }

    public Optional<Card> getContent() {
        return content.getValue();
    }

    public ObjectProperty<Optional<Card>> getContentProperty() {
        return content;
    }

    public void setContent(Card card) {
        this.content.set(Optional.ofNullable(card));
    }

    public Image getCardImage() {
//        System.out.println(getContent());
        if (getContent().isPresent()) {
            return new Image(getClass().getResourceAsStream("/cards/PNG/" + getContent().get().toString() + ".png"));
        }
        return null;
    }

    public enum Place {
        Deck,
        Rejected,
        Field
    }

    public static class Coordinates {

        private final int rowId;
        private final int columnId;

        public Coordinates(int rowId, int columnId) {
            if (rowId < 0 || rowId > 3) {
                throw new IllegalArgumentException("RowId value must be one of {0,1,2,3}. Actual value: " + rowId);
            }
            if (columnId < 0 || columnId > 7) {
                throw new IllegalArgumentException("ColumnId value must be one of {0,1,2,3,4,5,6,7}. Actual value: " + columnId);
            }
            this.rowId = rowId;
            this.columnId = columnId;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", rowId, columnId);
        }


        public int getRowId() {
            return rowId;
        }

        public int getColumnId() {
            return columnId;
        }

    }

    @Override
    public String toString() {
        return place.toString() + ":" + coordinates.toString() + " " + content.toString();
    }


}