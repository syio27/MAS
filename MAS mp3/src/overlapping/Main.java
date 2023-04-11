package overlapping;

import java.time.LocalDate;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {

        //shipMember can be 2 objects in a same time - Military and Scientist
        //Implemented with EnumSet and MemberType class {Military, Scientist, Specialist}
        Member shipMember = new Member("Kim", "Tae", LocalDate.now(), "Seoul", new String[]{"skill1", "skill2"}, EnumSet.of(MemberType.Military, MemberType.Scientist), "Major", "Physical science", "Physics", "description");

        //rocketMember can be 3 objects in a same time - Scientist, Military, Specialist
        Member rocketMember = new Member("Jhon", "Trevor", LocalDate.of(1966, 10, 23), "USA", new String[]{"skill1"}, EnumSet.of(MemberType.Specialist, MemberType.Scientist, MemberType.Military), "Pilot officer", "Biology", "Botany", "description");
    }
}
