package pl.edu.agh.sixes.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Objects;
import java.util.Optional;

public class CardContainer {

    private final Place place;
    private final Coordinates coordinates;
    private ObjectProperty<Card> content;

    public CardContainer(Place place, Coordinates coordinates, Card card) {
        this(place, coordinates);
        this.content = new SimpleObjectProperty<>(card);
    }

    public CardContainer(Place place, Coordinates coordinates) {
        this.place = place;
        this.coordinates = coordinates;
        this.content = new SimpleObjectProperty<>(null);
    }

    public Place getPlace() {
        return place;
    }

    public Optional<Coordinates> getCoordinates() {
        return Optional.ofNullable(coordinates);
    }

    public Optional<Card> getContent() {
        return Optional.ofNullable(content.get());
    }

    public ObjectProperty<Card> getContentProperty() {
        return content;
    }

    public void setContent(Card card) {
        this.content.set(card);
    }

    public enum Place {
        DECK,
        REJECTED,
        FIELD,
        TRASH
    }

    @Override
    public String toString() {
        return place.toString() + ":" + (Objects.isNull(coordinates) ? "null" : coordinates.toString()) + " " + content.toString();
    }


}
