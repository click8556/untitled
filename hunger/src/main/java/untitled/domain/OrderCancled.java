package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String foodid;
    private String opsion;
    private String addr;

    public OrderCancled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancled() {
        super();
    }
}
