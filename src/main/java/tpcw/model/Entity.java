package tpcw.model;

import java.sql.ResultSet;

public abstract class Entity {


    public Entity(ResultSet resultSet) {

    }

    public abstract int hashCode();
    public abstract boolean equals(Object e);

}
