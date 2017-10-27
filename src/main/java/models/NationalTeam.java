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
@Table(name = "nationalTeam")
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nationalTeam")
    private List<Player> players;

    public NationalTeam(String name) {
        this.name = name;
    }

    public NationalTeam(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

}