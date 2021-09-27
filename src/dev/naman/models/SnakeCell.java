package dev.naman.models;

public class SnakeCell extends Cell {
    int finalPosition;

    private SnakeCell(int cellPoition, int finalPosition) {
        this.position = new Position(cellPoition);
        this.finalPosition = finalPosition;
    }

    public static class Builder {}
}


// TODO
// CellFactory
// CellFactory.createNormalCell().atPositon();
// CellFactory.createCellWithSnake(). withFinalPosition()
// CellFactorycreateCellWithLadder().withFinalPosition()
// CellFactory.createMagicCell().
// Create Implementation SnakeCell, NormalCell, LadderCell
// Make the