package utils;

import constants.AwardType;
import constants.SportType;
import participant.Award;
import participant.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ParticipantUtils {
    public static Participant[] getParticipantsByAwardCountAndType(int count, AwardType awardType, Participant[] participants) {
        Predicate<Award> awardPredicate = award -> award.getAwardType() == awardType;
        Predicate<Participant> participantPredicate = participant -> participant.getAwards().stream().filter(awardPredicate).count() == count;

        return filterParticipants(participantPredicate, participants);
    }

    public static Participant[] getParticipantsByAwardCountAndType(int count, Participant[] participants) {
        Predicate<Participant> participantPredicate = participant -> participant.getAwards().size() == count;

        return filterParticipants(participantPredicate, participants);
    }

    public static Participant[] getParticipantsBySportType(SportType sportType, Participant[] participants) {
        Predicate<Participant> participantPredicate = participant -> participant.getSportType() == sportType;

        return filterParticipants(participantPredicate, participants);
    }

    private static Participant[] filterParticipants(Predicate<Participant> participantPredicate, Participant[] participants) {
        return Stream.of(participants).filter(participantPredicate).toArray(Participant[]::new);
    }

    public static Participant[] generateParticipants(int numberOfParticipants) {
        Participant[] participants = new Participant[numberOfParticipants];

        Participant participant;
        for (int i = 0; i < numberOfParticipants; i++) {
            String name = "name " + i;
            String surname = "Surname " + i;
            int age = i + 1;
            SportType sportType = SportType.values()[i % SportType.values().length];
            List<Award> awards = getRandomAwards();
            participant = new Participant(name, surname, age, sportType, awards);
            participants[i] = participant;
        }

        return participants;
    }

    public static List<Award> getRandomAwards() {
        int numberOfAwards = (int) (Math.random() * 10);
        List<Award> awards = new ArrayList<>();
        for (int i = 0; i < numberOfAwards; i++) {
            AwardType awardType = AwardType.values()[i % AwardType.values().length];
            awards.add(new Award("Award " + i, awardType));
        }
        return awards;
    }

    public static void printParticipants(Participant[] participants, String title) {
        System.out.println(title + ":");
        for (Participant p : participants) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------");
    }
}
