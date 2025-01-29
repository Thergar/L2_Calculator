package Lineage2Calculator.DbServices;

import jakarta.persistence.*;

/**
 * Represents a Town entity that maps to the "Town" table in the "L2_towns" database.
 * This entity stores information about towns, including their unique IDs and names.
 */
@Entity
@Table(name = "Town")
public class Town {

/**
 * The unique identifier of the town.
 * Mapped to the "town_id" column in the database and is the primary key.
 * Automatically generated using the {@code GenerationType.IDENTITY} strategy.
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    private Long townId;

/**
 * The name of the town.
 * Mapped to the "town_name" column in the database.
 * This field is unique and cannot be null.
 */
    @Column(name = "town_name", unique = true, nullable = false)
    private String townName;

/**
 * Default constructor with no-argument.
 * This constructor is not used by JPA in the current implementation
 * and should not be used directly.
 *
 * @deprecated JPA doesn't use no-argument constructor and exist only for compatibility purpose.
 */
    @Deprecated
    protected Town() {

    }

/**
 * Constructor to create a {@code Town} instance with specific town name.
 *
 * @param townName the name of the town.
 */
    public Town(String townName) {
        this.townName = townName;
    }

/**
 * Retrieves the unique identifier of the town.
 *
 * @return the town's ID.
 */
    public Long getTownId() {
        return townId;
    }

/**
 * Retrieves the name of the town.
 *
 * @return the town's name.
 */
    public String getTownName() {
        return townName;
    }

/**
 * Returns a string representation of the town entity.
 *
 * @return a string containing the town's ID and name.
 */
    @Override
    public String toString() {
        return "Town {" +
                "townId =" + townId +
                ", townName = '" + townName + '\'' +
                '}';
    }
}
