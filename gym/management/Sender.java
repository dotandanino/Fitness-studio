package gym.management;

import java.util.ArrayList;

public abstract class Sender {
    private final ArrayList<Member> members=new ArrayList<>();
    protected void register(Member member){
        members.add(member);
    }
    protected void unRegister(Member member){
        members.remove(member);
    }
    protected void notifyMembers(String newsletter){
        for (Member member: members){
            member.update(newsletter);
        }
    }
}
