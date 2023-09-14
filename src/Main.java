import constants.AwardType;
import constants.SportType;
import participant.Participant;
import utils.ParticipantUtils;

public class Main {
    public static void main(String[] args) {
        // 1. create an array of participants
        Participant[] participants = ParticipantUtils.generateParticipants(10);
        ParticipantUtils.printParticipants(participants, "All participants");

        // 2. Select participants by sport type
        Participant[] BasketBallParticipant = ParticipantUtils.getParticipantsBySportType(SportType.BASKETBALL, participants);
        ParticipantUtils.printParticipants(BasketBallParticipant, "Basketball participants");

        Participant[] FootballBallParticipant = ParticipantUtils.getParticipantsBySportType(SportType.FOOTBALL, participants);
        ParticipantUtils.printParticipants(FootballBallParticipant, "Football participants");

        // 3. select participants by count of awards
        Participant[] participantsWith3Awards = ParticipantUtils.getParticipantsByAwardCountAndType(3, participants);
        ParticipantUtils.printParticipants(participantsWith3Awards, "Participants with 3 awards");

        // 4. select participants by count of awards and award type
        // national
        Participant[] participantsWith5NationalAwards = ParticipantUtils.getParticipantsByAwardCountAndType(5, AwardType.NATIONAL, participants);
        ParticipantUtils.printParticipants(participantsWith5NationalAwards, "Participants with 5 national awards");
        // international
        Participant[] participantsWith2InterNationalAwards = ParticipantUtils.getParticipantsByAwardCountAndType(2, AwardType.INTERNATIONAL, participants);
        ParticipantUtils.printParticipants(participantsWith2InterNationalAwards, "Participants with 2 international awards");
    }
}