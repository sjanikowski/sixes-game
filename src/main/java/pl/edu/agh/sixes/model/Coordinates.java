package pl.edu.agh.sixes.model;

import java.util.Objects;

public class Coordinates {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return rowId == that.rowId &&
                columnId == that.columnId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rowId, columnId);
    }

    public int getRowId() {
        return rowId;
    }

    public int getColumnId() {
        return columnId;
    }



}
