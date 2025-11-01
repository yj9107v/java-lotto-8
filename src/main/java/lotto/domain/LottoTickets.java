package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = List.copyOf(tickets);
    }

    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }

    public List<Lotto> values() {
        return List.copyOf(tickets);
    }

    public int size() {
        return tickets.size();
    }
}
