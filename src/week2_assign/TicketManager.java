/*

TicketManager 클래스는 특정 수(LIMITS)만큼 Ticket을 발행하는 클래스
 - 단일쓰레드 환경에서 실행될 때 코드의 문제점은?
 - 문제점을 해결하기 위해 코드를 변경
 - 해결책이 다중 쓰레드에서 어떤 문제점이 발생하는가?

*/

package week2_assign;
import java.util.Optional;

public class TicketManager {
    private int count;
    private final int LIMITS = 2;
    public TicketManager() {
        count = 0;
    }

    public Optional<Ticket> issue() {
        if(count >= LIMITS) {
            System.out.print("ticket fail");
            return Optional.empty();
        }
        System.out.print("ticket success");
        return Optional.of(new Ticket(count++));
    }
}
