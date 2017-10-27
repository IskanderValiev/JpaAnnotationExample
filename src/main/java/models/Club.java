package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    public Club(String name) {
        this.name = name;
    }

    public Club(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    @Override
    public String toString() {
        return getName();
    }
}
