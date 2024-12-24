package gym.management;

import java.util.ArrayList;

public abstract class Sender {
    private final ArrayList<Member> members=new ArrayList<>();
    public void register(Member member){
        members.add(member);
    }
    public void unRegister(Member member){
        members.remove(member);
    }
    public void notifyMembers(String newsletter){
        for (Member member: members){
            member.update(newsletter);
        }
    }
}
