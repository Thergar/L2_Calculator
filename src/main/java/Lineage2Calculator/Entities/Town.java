package Lineage2Calculator.Entities;

import jakarta.persistence.*;

/**
 * Represents a Town entity mapped to the "Town" table in the "L2_towns" database.
 * This entity stores information about towns, including their unique IDs and names.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "Town", uniqueConstraints = @UniqueConstraint(columnNames = "town_name"))
public class Town {

/**
 * The unique identifier of the town.
 * <p>
 * Mapped to the "town_id" column in the database as the primary key.
 * Automatically generated using the {@code GenerationType.IDENTITY} strategy.
 * </p>
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id", updatable = false, nullable = false)
    private Long townId;

/**
 * The name of the town.
 * <p>
 * Mapped to the "town_name" column in the database.
 * This field is unique and cannot be null.
 * </p>
 */
    @Column(name = "town_name", unique = true, nullable = false)
    private String townName;


/**
 * Default no-argument constructor.
 * This constructor is necessary for Hibernate and JPA providers and should not be used directly.
 */
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
