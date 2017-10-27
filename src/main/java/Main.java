import dao.ClubDaoJPAImpl;
import models.Club;
import models.Player;

public class Main {

    public static void main(String[] args) {
        ClubDaoJPAImpl clubDaoJPA = new ClubDaoJPAImpl();

        Club club = clubDaoJPA.findByName("Rubin").get(0);

        Club clubSave = new Club("Borussia");

        clubDaoJPA.save(clubSave);

        Player player = new Player("Elmir", "Nabiullin", club.getId(), );

        System.out.println(clubDaoJPA.findByName("Rubin"));
        System.out.println("name of selected club is " + club.toString());
    }
}
