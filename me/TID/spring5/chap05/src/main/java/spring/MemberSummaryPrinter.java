package spring;

public class MemberSummaryPrinter extends MemberPrinter {

    @Override
    public void print(Member member) {
        System.out.printf(
                "회워 정보: 이메일 =%s, 이름=%n\n",
                member.getEmail(), member.getName());
    }
}
