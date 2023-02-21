package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;

    public CookStarted(Cooking aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
