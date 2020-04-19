package com.core.util;

import java.util.Objects;

public class Position {

    public float x;
    public float y;

    public Position() {
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Float.compare(position.x, x) == 0 &&
            Float.compare(position.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Position ");
        sb.append('(').append(x);
        sb.append(", ");
        sb.append(y).append(')');
        return sb.toString();
    }
}
