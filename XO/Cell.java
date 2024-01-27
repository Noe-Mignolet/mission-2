/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

/**
 * Represents a cell on the game board with a specified row and column.
 */
public class Cell {
    private final int row, col;

    /**
     * Constructs a new Cell with the given row and column.
     * @param row The row of the cell.
     * @param col The column of the cell.
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Copy constructor that creates a new Cell with the same row and column as the given Cell.
     * @param cell The Cell to copy.
     */
    public Cell(Cell cell) {
        this.row = cell.row;
        this.col = cell.col;
    }

    /**
     * Returns a string representation of the cell in the format "(row,col)".
     * @return String representation of the cell.
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", row, col);
    }

    /**
     * Gets the row of the cell.
     * @return The row of the cell.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the cell.
     * @return The column of the cell.
     */
    public int getCol() {
        return col;
    }
}